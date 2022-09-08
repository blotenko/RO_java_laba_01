import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


class solve extends javax.swing.JFrame {

    // frame
    static JFrame f;

    // slider
    static JSlider b;
    static thread mAnotherOpinion;
    static threadTwo mAnotherOpinionTwo;

    static int semafor = 0;

    // main class
    public static void main(String[] args)
    {
        // create a new frame
        f = new JFrame("frame");

        // create a slider
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,50);
     //   slider.addChangeListener(this);

        slider.setMajorTickSpacing(10);
        //slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(70,100,260,60);

        // create a button
        JButton button = new JButton("start Thread one");
        button.setBounds(87, 225, 115, 55);

        JButton buttonTwo = new JButton("start Thread two");
        buttonTwo.setBounds(207, 225, 115, 55);

        JButton closeButton = new JButton("close Thread one");
        closeButton.setBounds(87, 325, 115, 55);

        JButton closeButtonTwo = new JButton("close Thread two");
        closeButtonTwo.setBounds(207, 325, 115, 55);


        SpinnerModel valueFirst =
                new SpinnerNumberModel(1, //initial value
                        1, //minimum value
                        10, //maximum value
                        1); //step

        SpinnerModel valueSecond =
                new SpinnerNumberModel(1, //initial value
                        1, //minimum value
                        10, //maximum value
                        1); //step

        JSpinner spinnerOne = new JSpinner(valueFirst);
        spinnerOne.setBounds(100,170,50,30);

        JSpinner spinnerTwo = new JSpinner(valueSecond);
        spinnerTwo.setBounds(260,170,50,30);

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(semafor==0){
                    mAnotherOpinion = new thread(spinnerOne,spinnerTwo,slider);	//Создание потока

                    mAnotherOpinion.start(); 			//Запуск потока
                    semafor = 1;
                    spinnerOne.setValue(1);
                }


            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        buttonTwo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(semafor==0){
                    mAnotherOpinionTwo = new threadTwo(spinnerOne,spinnerTwo,slider);	//Создание потока

                    mAnotherOpinionTwo.start();
                    semafor = 1;
                    spinnerTwo.setValue(10);
                }

            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        closeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(mAnotherOpinion.isAlive() == true && semafor==1){
                    mAnotherOpinion.disable();		//Запуск потока
                    semafor = 0;
                    slider.setValue(50);
                }

            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        closeButtonTwo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(mAnotherOpinionTwo.isAlive() == true && semafor==1){
                    mAnotherOpinionTwo.disable();		//Запуск потока
                    semafor = 0;
                    slider.setValue(50);
                    spinnerTwo.setValue(1);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        // adding objects to frame
        f.add(slider);
        f.add(button);
        f.add(buttonTwo);
        f.add(closeButton);
        f.add(closeButtonTwo);
        f.add(spinnerOne);
        f.add(spinnerTwo);
        f.setUndecorated(true);
        JButton cancelButton = new JButton("close");
        cancelButton.setBounds(10, 10, 115, 55);
        cancelButton.setVisible(true);
        f.add(cancelButton);

        // set the size of frame
        f.setSize(400, 400);

        // uses no layout managers
        f.setLayout(null);

        // makes the frame visible
        f.setVisible(true);

        cancelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 mAnotherOpinion.disable();
                  mAnotherOpinionTwo.disable();
                System.exit(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });




    }

}

class thread extends Thread
{
    private boolean isActive;
    static JSpinner spinnerOne;
    static JSpinner spinnerTwo;
    static  JSlider slider;
    void disable(){
        isActive=false;
    }
    thread(JSpinner One, JSpinner Two, JSlider s){
        spinnerOne = One;
        spinnerTwo = Two;
        slider = s;
        isActive = true;

    }

    @Override
    public void run()
    {
        while(isActive){
           // if(Integer.parseInt(spinnerTwo.getValue().toString())>Integer.parseInt(spinnerOne.getValue().toString()))
           // {
             //   int res = Integer.parseInt(spinnerTwo.getValue().toString()) - Integer.parseInt(spinnerOne.getValue().toString());
             //   int res2 =  50+res*6;
             //   if(res2<90)
             //   {
             //       slider.setValue(res2);
             //   }
               // else
              //  {
                    slider.setValue(10);
              //  }
           // }
          //  else if(Integer.parseInt(spinnerTwo.getValue().toString())==Integer.parseInt(spinnerOne.getValue().toString()))
          //  {
            //    slider.setValue(50);
           // }

        }

    }
}

class threadTwo extends Thread
{
    private boolean isActive;
    static JSpinner spinnerOne;
    static JSpinner spinnerTwo;
    static  JSlider slider;
    void disable(){
        isActive=false;
    }
    threadTwo(JSpinner One, JSpinner Two, JSlider s){
        spinnerOne = One;
        spinnerTwo = Two;
        slider = s;
        isActive = true;
        // super(One,Two);
    }

    @Override
    public void run()
    {
        while(isActive){
            //if(Integer.parseInt(spinnerOne.getValue().toString()) > Integer.parseInt(spinnerTwo.getValue().toString()))
            //{
            //    int res = Integer.parseInt(spinnerOne.getValue().toString()) - Integer.parseInt(spinnerTwo.getValue().toString());

            //    int res2 =  50-res*6 ;
            //    if(res2>10)
            //    {
            //        slider.setValue(res2);
            //    }
             //   else
            //    {
                    slider.setValue(90);
            //    }
          //  }
          //  else if(Integer.parseInt(spinnerTwo.getValue().toString())==Integer.parseInt(spinnerOne.getValue().toString()))
          //  {
          //      slider.setValue(50);
          //  }
        }


    }
}