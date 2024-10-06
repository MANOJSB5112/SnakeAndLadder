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

	public static void main(String[] args) {
		SpringApplication.run(SnakeAndLadderApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Board board=new Board();
		BoardController boardController=new BoardController(board);
		Dice dice=new Dice(1,6);
		DiceController diceController=new DiceController(dice);
		List<Player> players=new ArrayList<>();
		players.add(new Player(1,"Chethan",1));
		players.add(new Player(2,"Manoj",1));
		players.add(new Player(3,"Rakshith",1));
		PlayerController playerController=new PlayerController(players);

		GameController gameController=new GameController(boardController,diceController,playerController);

		Scanner sc=new Scanner(System.in);

		int currentPlayerIndex;
		boolean gotWinner=false;

		log.info("Welcome, Lets Start the game");
		log.info("Who gonna start first? ");
		log.info("Enter 1 for Chethan | Enter 2 for Manoj | Enter 3 for Rakhith");

		currentPlayerIndex=sc.nextInt();

		gameController.start(currentPlayerIndex);

		while(gotWinner)
		{
			Player currentPlayer= gameController.getCurrentPlayer();

			gameController.takeTurn(currentPlayer);

			if (gameController.checkWinner(currentPlayer)) {
				gotWinner=true;
				System.out.println(currentPlayer.getName() + " wins!");
			}
		}
	}
}
