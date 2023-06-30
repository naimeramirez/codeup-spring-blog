package codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showDiceOptions() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guessedNum}")
    public String diceRoll(@PathVariable int guessedNum, Model model) {
        int diceRoll = (int) (Math.random() * 6 + 1);
//        int diceRoll = 3;
        boolean result = checkGuess(guessedNum, diceRoll);
        model.addAttribute("diceRoll", "Dice rolled: " + diceRoll);
        model.addAttribute("guessedNum", "Your guess: " + guessedNum);
        model.addAttribute("result", result);
        return "roll-dice-result";
    }

    static boolean checkGuess(int guessedNum, int diceRoll) {
        return guessedNum == diceRoll;
    }


}
