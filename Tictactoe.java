import javax.swing.*;

//import javaFix.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//main class Tictactoe
public class Tictactoe implements ActionListener
{
    //creating a window
    JFrame window=new JFrame("Tic-Tac-Toe");
    //crate a four panel
    // part of window is panel
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel=new JPanel();
     JPanel reloadPanel=new JPanel();
     JPanel scorePanel=new JPanel();

     // inside panel label are there ;
     JLabel textfield=new JLabel();
     JButton[] buttons=new JButton[9];
     JButton reloadButton=new JButton("reload");
     JButton closeButton=new JButton("close");
    JLabel ScoreLabelPlayerX=new JLabel();
    JLabel ScoreLabelPlayerY = new JLabel();
    
    
    int PlayerXscore=0;
    int PlayerYscore=0;

    boolean PlayerXturn;
    boolean PlayerYtrun;

    Tictactoe(){
        //setting window size
        window.setSize(1000,800);
        //setting background colour of window.
        window.getContentPane().setBackground(new Color(50,50,50));
        // setting boarder layout. 
        window.setLayout(new BorderLayout());
        //The setVisible(true) method makes the frame appear on the screen.other wise
        //it acts as a object inside a memory .not appear as an image.
        window.setVisible(true);


       //changing the colour of title plane 
       textfield.setBackground(new Color(25,25,25));
       //text color
       textfield.setForeground(new Color(25,255,0));
       textfield.setFont(new Font("Ink Free",Font.BOLD,75));
       textfield.setHorizontalAlignment(JLabel.CENTER);
       textfield.setText("TIC-TAC_TOE");
       textfield.setOpaque(true);
       titlePanel.setLayout(new BorderLayout());
       titlePanel.setBounds(0,0,800,100);
       
       buttonPanel.setLayout(new GridLayout(3,3));
       buttonPanel.setBackground(new Color(150,150,150));
       for(int i=0;i<9;i++){
        buttons[i]=new JButton();
        buttonPanel.add(buttons[i]);
       // buttons[i].setFont(new Font("MV Boli"),Font.BOLD,120);
       buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
       // if true ,only one button is zoom all other windows aremout of the box 
        buttons[i].setFocusable(false);
        //add an action listener to the close button
        buttons[i].addActionListener(this);
       
       }
      //in reload panel i row two coulmn 
      reloadPanel.setLayout(new GridLayout(1,2));
      reloadPanel.setBackground(new Color(150,150,150));
      reloadButton.setBackground(new Color(0,0,255));
      reloadButton.setFocusable(false);
      reloadButton.addActionListener(this);

      closeButton.setBackground(new Color(255,0,0));
       closeButton.setFocusable(false);
       closeButton.addActionListener(this);
       
     //add two buttons in reload panel
     reloadPanel .add(reloadButton);
     reloadPanel.add(closeButton);
     
     scorePanel.setLayout(new GridLayout(2,1));
     scorePanel.setBackground(new Color(255,255,0));

     ScoreLabelPlayerX.setFont(new Font("MV Boli",Font.BOLD,50));
     //seting text for this font.
     ScoreLabelPlayerX.setText("Player X :"+PlayerXscore);

     ScoreLabelPlayerX.setFont(new Font("MV Boli",Font.BOLD,20));
     ScoreLabelPlayerY.setText("Player O: "+PlayerYscore);

     scorePanel.add(ScoreLabelPlayerX);
     scorePanel.add(ScoreLabelPlayerY);

     // we have to all this stuff in window no ..
     window.add(titlePanel,BorderLayout.NORTH);
     window.add(buttonPanel);
     window.add(reloadPanel,BorderLayout.SOUTH);
     window.add(scorePanel,BorderLayout.EAST);
    
     firstTurn();

    }
    public void firstTurn(){
        try{
            //for first 1500ms it show tictactoe.
            Thread.sleep(15000);
        }
        catch(InterruptedException e){
         e.printStackTrace();
        }
        // below work is it give the chance equally to both the player.
        if(Math.random()<0.5){
            PlayerXturn=true;
            textfield.setText("X turn");

        }else{
            PlayerXturn=false;
            textfield.setText("Y Turn");
             
        }
       
    }
    @Override
    // inbuilt method it will catch action by this method 
    public void actionPerformed(ActionEvent e){
       for(int i=0;i<9;i++){
        //if any event performed in button 
        if(e.getSource()==buttons[i]){
               if(PlayerXturn)
               {
                  if(buttons[i].getText()=="")
                  {
                    buttons[i].setForeground(new Color(0,255,0));
                    buttons[i].setText("X");
                    PlayerXturn=false;
                    textfield.setText("Y turn");
                    textfield.setForeground(new Color(0,0,255));
                     check();
                   }
                  
               } else{
                if(buttons[i].getText()=="")
                {
                  buttons[i].setForeground(new Color(0,0,255));
                  buttons[i].setText("Y");
                  PlayerXturn=true;
                  textfield.setText("X turn");
                  textfield.setForeground(new Color(0,0,255));
                   check();
                 } 
              }

        }
       }
       if(e.getSource()==reloadButton){
        reload();
       // .........horizontal wining condition.............
       if(e.getSource()==closeButton){
        window.dispose();
       }
    }
}
     public void check(){
       if(buttons[0].getText()=="X"&&
          buttons[1].getText()=="X"&&
          buttons[2].getText()=="X"
       ){
         xwins(0,1,2);
       }
       if(buttons[3].getText()=="X"&&
          buttons[4].getText()=="X"&&
          buttons[5].getText()=="X"
       ){
         xwins(3,4,5);
       }

       if(buttons[6].getText()=="X"&&
          buttons[7].getText()=="X"&&
          buttons[8].getText()=="X"
       ){
         xwins(6,7,8);
       }

       if(buttons[0].getText()=="X"&&
          buttons[3].getText()=="X"&&
          buttons[6].getText()=="X"
       ){
         xwins(0,3,6);
       }
       if(buttons[1].getText()=="X"&&
          buttons[4].getText()=="X"&&
          buttons[7].getText()=="X"
       ){
         xwins(1,4,7);
       }
       if(buttons[2].getText()=="X"&&
          buttons[5].getText()=="X"&&
          buttons[8].getText()=="X"
       ){
         xwins(2,5,8);
       }
       if(buttons[0].getText()=="X"&&
          buttons[4].getText()=="X"&&
          buttons[8].getText()=="X"
       ){
         xwins(0,4,8);
       }
       
       if(buttons[2].getText()=="X"&&
          buttons[4].getText()=="X"&&
          buttons[6].getText()=="X"
       ){
         xwins(2,4,6);
       }

       //..............Y conditions.....................................................
       if(buttons[0].getText()=="X"&&
       buttons[1].getText()=="X"&&
       buttons[2].getText()=="X"
    ){
      ywins(0,1,2);
    }
    if(buttons[3].getText()=="X"&&
       buttons[4].getText()=="X"&&
       buttons[5].getText()=="X"
    ){
      ywins(3,4,5);
    }

    if(buttons[6].getText()=="X"&&
       buttons[7].getText()=="X"&&
       buttons[8].getText()=="X"
    ){
      ywins(6,7,8);
    }

    if(buttons[0].getText()=="X"&&
       buttons[3].getText()=="X"&&
       buttons[6].getText()=="X"
    ){
      ywins(0,3,6);
    }
    if(buttons[1].getText()=="X"&&
       buttons[4].getText()=="X"&&
       buttons[7].getText()=="X"
    ){
      ywins(1,4,7);
    }
    if(buttons[2].getText()=="X"&&
       buttons[5].getText()=="X"&&
       buttons[8].getText()=="X"
    ){
      ywins(2,5,8);
    }
    if(buttons[0].getText()=="X"&&
       buttons[4].getText()=="X"&&
       buttons[8].getText()=="X"
    ){
      ywins(0,4,8);
    }
    
    if(buttons[2].getText()=="X"&&
       buttons[4].getText()=="X"&&
       buttons[6].getText()=="X"
    ){
      ywins(2,4,6);
    }
      
     }
     public void xwins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
     
     for(int i=0;i<9;i++){
        buttons[i].setEnabled(false);
     }
    textfield.setText("X Wins");
    PlayerXscore++;
    ScoreLabelPlayerX.setText("Player X"+PlayerXscore);
    }
    public void ywins(int a,int b,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
     
     for(int i=0;i<9;i++){
        buttons[i].setEnabled(false);
     }
    textfield.setText("Y Wins");
    PlayerYscore++;
    ScoreLabelPlayerY.setText("Player Y"+PlayerYscore);
    }
    
    public void reload(){
        for(int i=0;i<9;i++){
            buttons[i].setText("");
            buttons[i].setBackground(new Color(240,240,240));
            buttons[i].setEnabled(true);
        }
        firstTurn();
    }
}