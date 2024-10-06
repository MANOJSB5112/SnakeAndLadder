
package com.example.snakeandladder;

import com.example.snakeandladder.controller.BoardController;
import com.example.snakeandladder.controller.DiceController;
import com.example.snakeandladder.controller.GameController;
import com.example.snakeandladder.controller.PlayerController;
import com.example.snakeandladder.model.Board;
import com.example.snakeandladder.model.Dice;
import com.example.snakeandladder.model.Player;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class SnakeAndLadderApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Board board = new Board();
		BoardController boardController = new BoardController(board);
		Dice dice = new Dice(1, 6);
		DiceController diceController = new DiceController(dice);
		List<Player> players = new ArrayList<>();
		players.add(new Player(1, "Chethan", 1));
		players.add(new Player(2, "Manoj", 1));
		players.add(new Player(3, "Rakshith", 1));
		PlayerController playerController = new PlayerController(players);

		GameController gameController = new GameController(boardController, diceController, playerController);
		startGame(gameController);
	}

	public void startGame(GameController gameController) {
		boolean gotWinner = false;
		Scanner sc = new Scanner(System.in);

		int currentPlayerIndex = -1;

		log.info("Welcome, Let's Start the game");
		log.info("Who is going to start first?");
		log.info("Enter 1 for Chethan | Enter 2 for Manoj | Enter 3 for Rakshith");

		while (currentPlayerIndex < 1 || currentPlayerIndex > 3) {
			log.info("Please enter a valid number (1, 2, or 3):");
			if (sc.hasNextInt()) {
				currentPlayerIndex = sc.nextInt();
			} else {
				sc.next();
			}
		}
		gameController.start(currentPlayerIndex-1);
		Player currentPlayer = gameController.getStartingPlayer();
		while (!gotWinner) {  // This ensures the loop runs until a winner is found
			log.info("It's " + currentPlayer.getName() + "'s turn! Please enter 'roll' to make a move");
			String command = sc.next();

			if ("roll".equalsIgnoreCase(command)) {
				gameController.takeTurn(currentPlayer);
			} else {
				log.error("Incorrect Command! Please enter 'roll' to make a move");
				continue;
			}

			if (gameController.checkWinner(currentPlayer)) {
				gotWinner = true;
				log.info(currentPlayer.getName() + " wins! the Game");
			}
			currentPlayer=gameController.getCurrentPlayer();
		}

		sc.close(); // Close the scanner
	}

	public static void main(String[] args) {
		SpringApplication.run(SnakeAndLadderApplication.class, args);
	}
}

