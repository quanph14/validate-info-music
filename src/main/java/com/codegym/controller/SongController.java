package com.codegym.controller;

import com.codegym.model.CheckFile;
import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView getAllSong(){
        ModelAndView modelAndView = new ModelAndView("/song/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateSong(){
        ModelAndView modelAndView = new ModelAndView("/song/create");
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createSong(@ModelAttribute SongForm songForm){
        MultipartFile multipartFile = songForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        ModelAndView modelAndView;
        if (CheckFile.checkFile(fileName)){
            try {
                FileCopyUtils.copy(songForm.getFile().getBytes(), new File(fileUpload + fileName));
            }catch (IOException ex) {
                ex.printStackTrace();
            }
            Song song = new Song(songForm.getId(), songForm.getName(),
                    songForm.getAuthor(), songForm.getCategory(), fileName);
            songService.save(song);
            modelAndView = new ModelAndView("/song/create");
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "Successfully");
        }else {
            modelAndView = new ModelAndView("/song/create");
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "This is not a song");
        }
        return modelAndView;
    }
}