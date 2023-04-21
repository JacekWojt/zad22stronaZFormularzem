package pl.jw.stronazformularzem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoinController {

    private CoinRepository coinRepository;
    private MailService mailService;

    public CoinController(CoinRepository coinRepository, MailService mailService) {
        this.coinRepository = coinRepository;
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/coin")
    public String coin(@RequestParam String name, Model model) {
        Coin coin = coinRepository.findByName(name);

        if (coin != null) {
            model.addAttribute("coin", coin);
            return "coin";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/messageform")
    public String getContact(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        return "messageform";
    }

    @PostMapping("/sendmessage")
    public String sendMessage(Message message) {
        mailService.sendMail(message.getSender(), message.getEmail(), message.getContent());
        return "success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
