package bigg.controller;

import bigg.model.Music;
import bigg.services.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    IMusicService musicService;

    @GetMapping("/home")
    public ModelAndView home(){
        Iterable<Music> music = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("music",music);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("music",new Music());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Music music, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/create");
        } else {
            musicService.save(music);
            return new ModelAndView("redirect:/home");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id){
        Music music = musicService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("music",music);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute Music music, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/edit");
        } else {
            musicService.save(music);
            return new ModelAndView("redirect:/home");
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        musicService.delete(id);
        return new ModelAndView("redirect:/home");
    }
}
