package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DiceRollSnake extends Application {

    public int rand;
    public Label randResult;

    public Circle player1;
    public Circle player2;

    public int cirPos[][] = new int[10][10];
    public int ladderPosition[][] = new int[6][6];

//    public int playerPosition1 = 1;
//    public int playerPosition2 = 1;

    public boolean player1Turn = true;
    public boolean player2Turn = true;

    public static int player1XPosition = 35;
    public static int player1YPosition = 665;

    public static int player2XPosition = 35;
    public static int player2YPosition = 665;

    public int posCir1 = 1;
    public int posCir2 = 1;

    public boolean gameStart = false;
    public Button gameButton;

    public static final int Tile_Size = 70;
    public static final int Width = 10;
    public static final int Height = 10;

    private Group tileGroup = new Group();

    private Parent createContent(){

        Pane root = new Pane();
        root.setPrefSize(Width*Tile_Size,(Height*Tile_Size)+70);  //+70 for buttons
        root.getChildren().addAll(tileGroup);

        for(int i=0;i<Height;i++){
            for(int j=0;j<Width;j++){
                Tile tile = new Tile(Tile_Size,Tile_Size);
                tile.setTranslateX(j*Tile_Size);
                tile.setTranslateY(i*Tile_Size);

                tileGroup.getChildren().add(tile);
            }
        }

        player1 = new Circle(35);
        player1.setId("player1");
        player1.getStyleClass().add("style.css");
        player1.setFill(Color.AQUA);
        player1.setTranslateX(player1XPosition);
        player1.setTranslateY(player1YPosition);

        player2 = new Circle(35);
        player2.setId("player2");
        player2.getStyleClass().add("sample/style.css");
        player1.setFill(Color.CHOCOLATE);
        player2.setTranslateX(player2XPosition);
        player2.setTranslateY(player2YPosition);

        Button button = new Button("Player1");
        button.setTranslateX(600);
        button.setTranslateY(710);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameStart){
                    if(player1Turn){
                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        move1Player();
                        translatePlayer(player1XPosition,player1YPosition,player1);
                        player1Turn=false;
                        player2Turn=true;


                        // Ladders
                        if(player1XPosition==175 && player1YPosition==665){
                            translatePlayer(player1XPosition=105,player1YPosition=455,player1);
                            posCir1++;
                        }
                        if(player1XPosition==665 && player1YPosition==665){
                            translatePlayer(player1XPosition=595,player1YPosition=595,player1);
                            posCir1++;
                        }
                        if(player1XPosition==455 && player1YPosition==525){
                            translatePlayer(player1XPosition=525,player1YPosition=315,player1);
                            posCir1++;
                        }
                        if(player1XPosition==315 && player1YPosition==315){
                            translatePlayer(player1XPosition=245,player1YPosition=105,player1);
                            posCir1++;
                        }
                        if(player1XPosition==35 && player1YPosition==245){
                            translatePlayer(player1XPosition=105,player1YPosition=35,player1);
                            posCir1++;
                        }
                        if(player1XPosition==595 && player1YPosition==175){
                            translatePlayer(player1XPosition=665,player1YPosition=105,player1);
                            posCir1++;
                        }

                        // Snakes
                        if(player1XPosition==315 && player1YPosition==595){
                            translatePlayer(player1XPosition=525,player1YPosition=595,player1);

                        }
                        if(player1XPosition==665 && player1YPosition==455){
                            translatePlayer(player1XPosition=245,player1YPosition=665,player1);
                            posCir2++;
                        }
                        if(player1XPosition==455 && player1YPosition==385){
                            translatePlayer(player1XPosition=315,player1YPosition=525,player1);

                        }
                        if(player1XPosition==175 && player1YPosition==245){
                            translatePlayer(player1XPosition=35,player1YPosition=315,player1);
                            posCir2++;
                        }
                        if(player1XPosition==385 && player1YPosition==245){
                            translatePlayer(player1XPosition=595,player1YPosition=315,player1);
                            posCir2++;
                        }
                        if(player1XPosition==245 && player1YPosition==35){
                            translatePlayer(player1XPosition=385,player1YPosition=175,player1);

                        }
                    }
                }
            }
        });


        Button button2 = new Button("Player2");
        button2.setTranslateX(70);
        button2.setTranslateY(710);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameStart){
                    if(player2Turn){
                        getDiceValue();
                        randResult.setText(String.valueOf(rand));
                        move2Player();
                        translatePlayer(player2XPosition,player2YPosition,player2);
                        player2Turn=false;
                        player1Turn=true;


                        // Ladders
                        if(player2XPosition==175 && player2YPosition==665){
                            translatePlayer(player2XPosition=105,player2YPosition=455,player2);
                            posCir2++;
                        }
                        if(player2XPosition==665 && player2YPosition==665){
                            translatePlayer(player2XPosition=595,player2YPosition=595,player2);
                            posCir2++;
                        }
                        if(player2XPosition==455 && player2YPosition==525){
                            translatePlayer(player2XPosition=525,player2YPosition=315,player2);
                            posCir2++;
                        }
                        if(player2XPosition==315 && player2YPosition==315){
                            translatePlayer(player2XPosition=245,player2YPosition=105,player2);
                            posCir2++;
                        }
                        if(player2XPosition==35 && player2YPosition==245){
                            translatePlayer(player2XPosition=105,player2YPosition=35,player2);
                            posCir2++;
                        }
                        if(player2XPosition==595 && player2YPosition==175){
                            translatePlayer(player2XPosition=665,player2YPosition=105,player2);
                            posCir2++;
                        }

                        // Snakes
                        if(player2XPosition==315 && player2YPosition==595){
                            translatePlayer(player2XPosition=525,player2YPosition=595,player2);

                        }
                        if(player2XPosition==665 && player2YPosition==455){
                            translatePlayer(player2XPosition=245,player2YPosition=665,player2);
                            posCir2++;
                        }
                        if(player2XPosition==455 && player2YPosition==385){
                            translatePlayer(player2XPosition=315,player2YPosition=525,player2);

                        }
                        if(player2XPosition==175 && player2YPosition==245){
                            translatePlayer(player2XPosition=35,player2YPosition=315,player2);
                            posCir2++;
                        }
                        if(player2XPosition==385 && player2YPosition==245){
                            translatePlayer(player2XPosition=595,player2YPosition=315,player2);
                            posCir2++;
                        }
                        if(player2XPosition==245 && player2YPosition==35){
                            translatePlayer(player2XPosition=385,player2YPosition=175,player2);

                        }
                    }
                }
            }
        });

        gameButton = new Button("Start Game");
        gameButton.setTranslateX(340);
        gameButton.setTranslateY(710);
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameButton.setText("Game Started");
                player1XPosition=35;
                player1YPosition=665;
                player2XPosition=35;
                player2YPosition=665;

                player1.setTranslateX(player1XPosition);
                player1.setTranslateY(player1YPosition);
                player2.setTranslateX(player2XPosition);
                player2.setTranslateY(player2YPosition);

                gameStart = true;
                player1Turn = true;
                player2Turn = true;
                randResult.setText("");
            }
        });

        randResult = new Label("0");
        randResult.setTranslateX(250);
        randResult.setTranslateY(710);

        Image img = new Image("snakebg.jpg");
        ImageView bgImage = new ImageView();
        bgImage.setImage(img);
        bgImage.setFitHeight(700);
        bgImage.setFitWidth(700);

        tileGroup.getChildren().addAll(bgImage,player1,player2,button,button2,gameButton,randResult);
        return root;

    }
    private void move1Player(){
        for(int i=0;i<rand;i++){
            if(posCir1%2==1){
                player1XPosition+=70;
            }
            if(posCir1%2==0){
                player1XPosition-=70;
            }
            if(player1XPosition>665){
                player1XPosition-=70;
                player1YPosition-=70;
                posCir1++;
            }
            if(player1XPosition<35){
                player1XPosition+=70;
                player1YPosition-=70;
                posCir1++;
            }
            if(player1XPosition<30 || player1YPosition<30){
                player1XPosition=35;
                player1YPosition=35;
                randResult.setText("Player 1 won");
                gameButton.setText("Start Again");
            }
        }
    }
    private void move2Player(){
        for(int i=0;i<rand;i++){
            if(posCir2%2==1){
                player2XPosition+=70;
            }
            if(posCir2%2==0){
                player2XPosition-=70;
            }
            if(player2XPosition>665){
                player2XPosition-=70;
                player2YPosition-=70;
                posCir2++;
            }
            if(player2XPosition<35){
                player2XPosition+=70;
                player2YPosition-=70;
                posCir2++;
            }
            if(player2XPosition<30 || player2YPosition<30){
                player2XPosition=35;
                player2YPosition=35;
                randResult.setText("Player 2 won");
                gameButton.setText("Start Again");
            }
        }
    }

    private void getDiceValue(){
        rand = (int) (Math.random()*6+1);
    }

    private void translatePlayer(int x, int y, Circle b){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Snakes and Ladders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
