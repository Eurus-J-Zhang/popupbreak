package com.designproject.view;


import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static com.designproject.utils.ButtonCommands.ADD;
import static com.designproject.utils.ButtonCommands.BUSY;
import static com.designproject.utils.ButtonCommands.LAZY;
import static com.designproject.utils.ButtonCommands.NORMAL;
import static com.designproject.utils.ImageUtils.resizeIcon;

public class TabSettings extends JComponent implements ActionListener{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    int hourFrWaterBreak = 00;
    int minFrWaterBreak = 30;
    int secFrWaterBreak = 03;

    int amountWaterBreak = 500;

    int hourFrExercise = 02;
    int minFrExercise = 30;
    int secFrExercise = 00;

    int amountExercise = 45;

    int hourFrEye = 01;
    int minFrEye = 00;
    int secFrEye = 15;

    int amountEye = 3;

    int hourFrSnack = 00;
    int minFrSnack = 45;
    int secFrSnack = 00;

    int amountSnack = 45;

    int hourFrB = 00;
    int minFrB = 35;
    int secFrB = 20;

    int amountB = 60;

    boolean toggle = false ;

    JPanel settingsControls;
    JPanel panelVC;

    JButton buttonLazy;
    JButton buttonBusy;
    JButton buttonNormal;

    JTextField breathAmount;
    JTextField eyeAmount;
    JTextField breathmin;
    JTextField eyemin;
    JTextField snackmin;
    JTextField snackHour;
    JTextField exercisemin;
    JTextField exerciseHour;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    public TabSettings(){

        // Initialize attributes
        settingsControls = new JPanel();
        panelVC = new JPanel(new GridBagLayout());

        // Layout
        setLayout(new BorderLayout());

        // Title
//        JLabel label = new JLabel("custimization of reminders ");
//        add(label,BorderLayout.NORTH);

        // East panel
        //panelVC.setBackground(Color.WHITE);
        GridBagConstraints vcConstraints = new GridBagConstraints();
        AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,16,16);

        JLabel select = new JLabel("<html>You can also select from<br>" +
                " our default configurations<br/>" +
                " or your custom ones:</html>");
        //select.setBackground(Color.WHITE);
        select.setBorder(brdrLeft);
        vcConstraints.fill = GridBagConstraints.HORIZONTAL;
        vcConstraints.gridx = 0;
        vcConstraints.gridy = 0;
        vcConstraints.gridwidth = 1;
        vcConstraints.insets = new Insets(5,5,5,5);
        panelVC.add(select, vcConstraints);

        URL url = getClass().getResource("/animations/wink.gif");
        vcConstraints.fill = GridBagConstraints.VERTICAL;
        vcConstraints.gridx = 0;
        vcConstraints.gridy = 1;
        vcConstraints.gridwidth = 1;
        vcConstraints.ipady = 10;
        vcConstraints.insets = new Insets(5,5,5,5);
        panelVC.add(new JLabel(new ImageIcon(url)), vcConstraints);

        buttonLazy = new JButton("  Lazy Day   ");
        buttonLazy.addActionListener(this);
        buttonLazy.setActionCommand(LAZY);
        vcConstraints.gridx = 0;
        vcConstraints.gridy = 2;
        vcConstraints.fill = GridBagConstraints.NONE;
        vcConstraints.gridwidth = 1;
        vcConstraints.ipady = 10;
        vcConstraints.insets = new Insets(5,5,5,5);
        panelVC.add(buttonLazy, vcConstraints);

        buttonBusy = new JButton("  Busy Day  ");
        buttonBusy.addActionListener(this);
        buttonBusy.setActionCommand(BUSY);
        vcConstraints.gridx = 0;
        vcConstraints.gridy = 3;
        vcConstraints.fill = GridBagConstraints.NONE;
        vcConstraints.gridwidth = 1;
        vcConstraints.ipady = 10;
        vcConstraints.insets = new Insets(5,5,5,5);
        panelVC.add(buttonBusy, vcConstraints);

        buttonNormal = new JButton("  Normal Day  ");
        buttonNormal.addActionListener(this);
        buttonNormal.setActionCommand(NORMAL);
        vcConstraints.gridx = 0;
        vcConstraints.gridy = 4;
        vcConstraints.fill = GridBagConstraints.NONE;
        vcConstraints.gridwidth = 1;
        vcConstraints.ipady = 10;
        vcConstraints.insets = new Insets(5,5,5,5);
        panelVC.add(buttonNormal, vcConstraints);

        add(panelVC, BorderLayout.EAST);

        // Center panel
        settingsControls.setLayout(new BoxLayout(settingsControls,BoxLayout.Y_AXIS));

        JPanel Titles = new JPanel();

        Titles.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel ONOFF = new JLabel("  ON/OFF  ");
        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 0 ;
        c.weightx = 0.5;
        c.weighty = 0.1;
        Titles.add(ONOFF,c);

        JLabel reminder = new JLabel("  Reminder  ");
        c.gridwidth = 1;
        c.gridx = 1; c.gridy= 0 ;
        c.weightx = 0.5;
        Titles.add(reminder,c);

        JLabel Frequency = new JLabel("  Frequency  ");
        c.gridwidth = 5;
        c.gridx = 2; c.gridy= 0 ;
        c.weightx = 0.5;
        Titles.add(Frequency,c);

        JLabel AmountDuration = new JLabel("  Amount/Duration  ");
        c.gridwidth = 2;
        c.gridx = 7; c.gridy= 0;
        c.weightx = 0.5;

        Titles.add(AmountDuration,c);
        settingsControls.add(Titles);

        JPanel panWater = new JPanel();
        panWater.setLayout(new GridLayout(0,9));

        JCheckBox switchWater = new JCheckBox("<html></html>", true);
        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 1 ;
        Titles.add(switchWater,c);

        JLabel waterLab = new JLabel("  Water  ", resizeIcon(
                new ImageIcon(getClass().getResource("/images/water.png")), 80, 80
        ), JLabel.CENTER);
        c.gridwidth = 1;
        c.gridx = 1; c.gridy= 1 ;
        Titles.add(waterLab,c);

        JTextField waterHour = new JTextField("  " + hourFrWaterBreak + "  ");
        c.gridwidth = 1;
        c.gridx = 2; c.gridy= 1 ;
        Titles.add(waterHour,c);

        JLabel wb1 = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 3; c.gridy= 1 ;
        Titles.add(wb1,c);

        JTextField watermin = new JTextField("  "+minFrWaterBreak + "  ");
        c.gridwidth = 1;
        c.gridx = 4; c.gridy= 1 ;
        Titles.add(watermin,c);

        JLabel wb2 = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 5; c.gridy= 1 ;
        Titles.add(wb2,c);

        JTextField watersec = new JTextField("  "+secFrWaterBreak + "  ");

        c.gridwidth = 1;
        c.gridx = 6; c.gridy= 1 ;
        Titles.add(watersec,c);

        JTextField waterAmount = new JTextField("  " + amountWaterBreak + "  ");
        c.gridwidth = 1;
        c.gridx = 7; c.gridy= 1 ;
        Titles.add(waterAmount,c);
        JLabel waterAmountLab = new JLabel("  mL  ");

        c.gridwidth = 1;
        c.gridx = 8; c.gridy= 1 ;
        Titles.add(waterAmountLab,c);


        // end of water tab

        JPanel panExercise = new JPanel();
        panExercise.setLayout(new GridLayout());

        //JButton switchExercise = new JButton("  X  ");
        JCheckBox switchExercise = new JCheckBox("<html></html>", true);
        //switchExercise.setBackground(Color.RED);
        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 2 ;
        Titles.add(switchExercise,c);
        JLabel exerciseLab = new JLabel("  Exercise  ", resizeIcon(
                new ImageIcon(getClass().getResource("/images/exercise.jpg")), 80, 80
        ), JLabel.CENTER);
        c.gridwidth = 1;
        c.gridx = 1; c.gridy= 2 ;
        Titles.add(exerciseLab,c);
        exerciseHour = new JTextField("  " + hourFrExercise +"  ");
        c.gridwidth = 1;
        c.gridx = 2; c.gridy= 2 ;
        Titles.add(exerciseHour,c);
        JLabel eb1 = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 3; c.gridy= 2 ;
        Titles.add(eb1,c);
        exercisemin = new JTextField("  " + minFrExercise+ "  ");
        c.gridwidth = 1;
        c.gridx = 4; c.gridy= 2 ;
        Titles.add(exercisemin,c);
        JLabel eb2 = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 5; c.gridy= 2 ;
        Titles.add(eb2,c);
        JTextField exercisesec = new JTextField("  " + secFrExercise + "  ");
        c.gridwidth = 1;
        c.gridx = 6; c.gridy= 2 ;
        Titles.add(exercisesec,c);
        JTextField exerciseAmount = new JTextField("  " + amountExercise+ "  ");
        c.gridwidth = 1;
        c.gridx = 7; c.gridy= 2 ;
        Titles.add(exerciseAmount,c);
        JLabel exerciseAmountLab = new JLabel("  min  ");
        c.gridwidth = 1;
        c.gridx = 8; c.gridy= 2 ;
        Titles.add(exerciseAmountLab,c);

        // end of exercise

        //begin eye exercise

        JPanel panEye = new JPanel();
        panEye.setLayout(new GridLayout());

        JCheckBox switchEye = new JCheckBox("<html></html>", true);
        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 3 ;
        Titles.add(switchEye,c);
        JLabel eyeLab = new JLabel("  Eye Breaks  ", resizeIcon(
                new ImageIcon(getClass().getResource("/images/eye.jpg")), 80, 80
        ), JLabel.CENTER);
        c.gridwidth = 1;
        c.gridx = 1; c.gridy= 3 ;
        Titles.add(eyeLab,c);

        JTextField eyeHour = new JTextField(" " + hourFrEye + " ");
        c.gridwidth = 1;
        c.gridx = 2; c.gridy= 3 ;
        Titles.add(eyeHour,c);

        JLabel elb = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 3; c.gridy= 3 ;
        Titles.add(elb,c);

        eyemin = new JTextField(" " + minFrEye + "  ");
        c.gridwidth = 1;
        c.gridx = 4; c.gridy= 3 ;
        Titles.add(eyemin,c);

        JLabel elb2 = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 5; c.gridy= 3 ;
        Titles.add(elb2,c);

        JTextField eyesec = new JTextField(" " + secFrEye + " ");
        c.gridwidth = 1;
        c.gridx = 6; c.gridy= 3 ;
        Titles.add(eyesec,c);

        eyeAmount = new JTextField(" " + amountEye + "  ");
        c.gridwidth = 1;
        c.gridx = 7; c.gridy= 3 ;
        Titles.add(eyeAmount,c);

        JLabel eyeAmountLab = new JLabel("  min  ");
        c.gridwidth = 1;
        c.gridx = 8; c.gridy= 3 ;
        Titles.add(eyeAmountLab,c);

        // end of eye

        //begin snack

        JPanel panSnack = new JPanel();
        panSnack.setLayout(new GridLayout());

        JCheckBox switchSnack = new JCheckBox("<html></html>", true);
        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 4 ;
        Titles.add(switchSnack,c);
        JLabel snackLab = new JLabel("  Snacking  ", resizeIcon(
                new ImageIcon(getClass().getResource("/images/eating.jpg")), 80, 80
        ), JLabel.CENTER);
        c.gridwidth = 1;
        c.gridx = 1; c.gridy= 4 ;
        Titles.add(snackLab,c);

        snackHour = new JTextField(" " + hourFrSnack + " ");
        c.gridwidth = 1;
        c.gridx = 2; c.gridy= 4 ;
        Titles.add(snackHour,c);

        JLabel b1S = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 3; c.gridy= 4 ;
        Titles.add(b1S,c);

        snackmin = new JTextField(" " + minFrSnack +" ");
        c.gridwidth = 1;
        c.gridx = 4; c.gridy= 4 ;
        Titles.add(snackmin,c);

        JLabel b2S = new JLabel("  :  ");
        c.gridwidth = 1;
        c.gridx = 5; c.gridy= 4 ;
        Titles.add(b2S,c);

        JTextField snacksec = new JTextField(" " + secFrSnack +" ");
        c.gridwidth = 1;
        c.gridx = 6; c.gridy= 4 ;
        Titles.add(snacksec,c);

        JTextField snackAmount = new JTextField(" "+ amountSnack+" ");
        c.gridwidth = 1;
        c.gridx = 7; c.gridy= 4 ;
        Titles.add(snackAmount,c);

        JLabel snackAmountLab = new JLabel(" snacks ");
        c.gridwidth = 1;
        c.gridx = 8; c.gridy= 4 ;
        Titles.add(snackAmountLab,c);

        settingsControls.add(panSnack);

        // end snack

        // begin breathing

        JPanel panBreath = new JPanel();
        panBreath.setLayout(new GridLayout());

        JCheckBox switchBreath = new JCheckBox("<html></html>", true);
        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 5 ;
        Titles.add(switchBreath,c);
        JLabel breathLab = new JLabel("  Breathing  ", resizeIcon(
                new ImageIcon(getClass().getResource("/images/breathing.png")), 80, 80
        ), JLabel.CENTER);

        c.gridwidth = 1;
        c.gridx = 1; c.gridy= 5 ;
        Titles.add(breathLab,c);

        JTextField breathHour = new JTextField(" " + hourFrB + " ");

        c.gridwidth = 1;
        c.gridx = 2; c.gridy= 5 ;
        Titles.add(breathHour,c);

        JLabel br1S = new JLabel("  :  ");

        c.gridwidth = 1;
        c.gridx = 3; c.gridy= 5 ;
        Titles.add(br1S,c);

        breathmin = new JTextField(" " + minFrB + " ");

        c.gridwidth = 1;
        c.gridx = 4; c.gridy= 5 ;
        Titles.add(breathmin,c);

        JLabel br2S = new JLabel("  :  ");

        c.gridwidth = 1;
        c.gridx = 5; c.gridy= 5 ;
        Titles.add(br2S,c);

        JTextField breathsec = new JTextField(" " + secFrB +" ");

        c.gridwidth = 1;
        c.gridx = 6; c.gridy= 5 ;
        Titles.add(breathsec,c);

        breathAmount = new JTextField(" " + amountB + " ");

        c.gridwidth = 1;
        c.gridx = 7; c.gridy= 5 ;
        Titles.add(breathAmount,c);

        JLabel breathAmountLab = new JLabel(" min ");

        c.gridwidth = 1;
        c.gridx = 8; c.gridy= 5 ;
        Titles.add(breathAmountLab,c);

        settingsControls.add(panBreath);

        // end of breath

        // begin buttons

        JPanel buttonControls = new JPanel();
        buttonControls.setLayout(new GridLayout());
        JButton customReminderAdd = new JButton("+");
        customReminderAdd.addActionListener(this);
        customReminderAdd.setActionCommand(ADD);

        c.gridwidth = 1;
        c.gridx = 0; c.gridy= 7;
        Titles.add(customReminderAdd,c);

        JButton cancelButton = new JButton("Cancel");

        c.gridwidth = 4;
        c.gridx = 2; c.gridy= 7 ;
        Titles.add(cancelButton,c);

        JButton saveButton = new JButton("Save");

        c.gridwidth = 2;
        c.gridx = 7; c.gridy= 7 ;
        Titles.add(saveButton,c);

        settingsControls.add(buttonControls, BOTTOM_ALIGNMENT);

        add(settingsControls, BorderLayout.CENTER);

        repaint();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    public void newReminderCustom(String text, String amountReminder){

        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());

        JButton switchButton = new JButton("  O  ");
        switchButton.setBackground(Color.GREEN);
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getActionCommand().contentEquals("  O  ")) {
                    switchButton.setBackground(Color.RED);
                    switchButton.setText("  X  ");
                    toggle = false;
                }
                else {
                    switchButton.setBackground(Color.GREEN);
                    switchButton.setText("  O  ");
                    toggle = true;
                }
            }
        });
        JLabel Lab = new JLabel("  " + text + "  ");
        JTextField Hour = new JTextField(" " + hourFrEye + " ");
        JLabel lb = new JLabel("  :  ");
        JTextField min = new JTextField(" " + minFrEye + "  ");
        JLabel lb2 = new JLabel("  :  ");
        JTextField sec = new JTextField(" " + secFrEye + " ");
        JTextField Amount = new JTextField(" " + amountEye + "  ");
        JLabel AmountLab = new JLabel("  "+ amountReminder+"  ");

        pan.add(switchButton);
        pan.add(Lab);
        pan.add(Hour);
        pan.add(lb);
        pan.add(min);
        pan.add(lb2);
        pan.add(sec);
        pan.add(Amount);
        pan.add(AmountLab);

        pan.repaint();

        settingsControls.add(pan);
        settingsControls.repaint();

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String command = actionEvent.getActionCommand();

        if (LAZY.equals(command)) {
            breathAmount.setText("  30  ");
            breathAmount.repaint();

            eyeAmount.setText("  05  ");
            eyeAmount.repaint();

            breathmin.setText("  15  ");
            breathmin.repaint();

            eyemin.setText("  10  ");
            eyemin.repaint();

            snackmin.setText("  33  ");
            snackmin.repaint();

            snackHour.setText( "  01  ");
            snackHour.repaint();

            exercisemin.setText("  45  ");
            exercisemin.repaint();
        }
        else if (BUSY.equals(command)) {
            breathAmount.setText("  20  ");
            breathAmount.repaint();

            eyeAmount.setText("  03  ");
            eyeAmount.repaint();

            breathmin.setText("  05  ");
            breathmin.repaint();

            eyemin.setText("  40  ");
            eyemin.repaint();

            snackmin.setText("  53  ");
            snackmin.repaint();

            snackHour.setText( "  00  ");
            snackHour.repaint();

            exercisemin.setText("  55  ");
            exercisemin.repaint();

            exerciseHour.setText("  02  ");
            exerciseHour.repaint();
        }
        else if (NORMAL.equals(command)) {
            breathAmount.setText("  59  ");
            breathAmount.repaint();

            eyeAmount.setText("  01  ");
            eyeAmount.repaint();

            breathmin.setText("  59  ");
            breathmin.repaint();

            eyemin.setText("  20  ");
            eyemin.repaint();

            snackmin.setText("  45  ");
            snackmin.repaint();

            snackHour.setText( "  40  ");
            snackHour.repaint();

            exercisemin.setText("  03  ");
            exercisemin.repaint();

            exercisemin.setText("  55  ");
            exercisemin.repaint();
        }
        else if (ADD.equals(command)) {
            JDialog form = new JDialog();
            form.setSize(100,200);
            form.setTitle("New reminder");

            JPanel panny  = new JPanel();
            panny.setLayout(new GridLayout(7,1));

            JLabel nameReminder = new JLabel("  Name  " );
            JTextField reminder = new JTextField("Social break");
            JLabel freqReminder = new JLabel("  Frequency  " );
            JTextField frequency = new JTextField("02:30:00");
            JLabel amountReminder = new JLabel("  Amount  " );
            JTextField amountreminder = new JTextField("10min");
            JButton createButton = new JButton("  Create Reminder  ");
            createButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //newReminderCustom((String) reminder.getText(), amountreminder.getText());
                    form.setVisible(false);
                }
            });

            panny.add(nameReminder);
            panny.add(reminder);
            panny.add(freqReminder);
            panny.add(frequency);
            panny.add(amountReminder);
            panny.add(amountreminder);
            panny.add(createButton);

            form.add(panny);

            form.pack();
            form.setLocationRelativeTo(this);
            form.setVisible(true);
        }

        repaint();
    }
}
