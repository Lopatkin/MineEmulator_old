package com.company.vizor101;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame{
    public int Balance = 100;
    public int mineCount;
    public int dayCount;
    public int dayIncome;
    public int headLevel = 1;
    public int headUpdateCost = 1000;
    public int maxMinPerHeadLevel = 10;
    public int mineDayIncome=24;
    public int mineBuildCost = 50;

    private JButton buttonNextDay = new JButton("НОВЫЙ ДЕНЬ");
    private JButton buttonAddMine = new JButton("Построить шахту за " + mineBuildCost + " г");
    private JButton buttonUpgradeHead = new JButton("Апгрейднуть штаб за " + headUpdateCost + " г");
    public JLabel labelInfo = new JLabel("Информация");
    public JLabel labelHeadLevel = new JLabel("Уровень штаба " + headLevel);
    public JLabel labelMineCount = new JLabel("Количество шахт: " + mineCount);
    public JLabel labelBalance = new JLabel("Текущий баланс: " + Balance);
    public JLabel labelDayCount = new JLabel("Текущий день: ");
    public JLabel labelDayIncome = new JLabel("Текущая прибыль: ");

    public JLabel labelMineInfo = new JLabel("Каждая шахта приносит " + mineDayIncome+ " золота в день.");


    class buttonNextDayActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Balance += mineCount * mineDayIncome;
            labelBalance.setText("Текущий баланс: " + Balance);

            dayCount ++;
            dayIncome = mineCount * mineDayIncome;
            labelDayCount.setText("Текущий день: " + dayCount);
            labelDayIncome.setText("Текущая прибыль: " + dayIncome + " в день");

            labelInfo.setText("Новый день настал!");

            SimpleGUI app1 = new SimpleGUI();
            app1.setVisible(true);

        }
    }

    class buttonAddMineListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (Balance >= mineBuildCost) {
                if (mineCount < headLevel * maxMinPerHeadLevel) {
                    Balance -= mineBuildCost;
                    mineCount++;
                    dayIncome = mineCount * mineDayIncome;
                    labelBalance.setText("Текущий баланс: " + Balance);
                    labelMineCount.setText("Количество шахт: " + mineCount);
                    labelInfo.setText("Шахта построена!");

                    labelDayIncome.setText("Текущая прибыль: " + dayIncome + " в день");
                } else {
                    labelInfo.setText("Поднимите уровень штаба!");
                }
            } else {
                labelInfo.setText("Не хватает денег на постройку!");
            }
        }
    }

    class buttonUpgradeHeadListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (Balance < headUpdateCost){
                labelInfo.setText("Не хватает денег для апгрейда штаба!");
            } else {
                Balance -= headUpdateCost;
                headLevel ++;
                labelInfo.setText("Штаб апгрейднут до " + headLevel + "уровня");
                labelBalance.setText("Текущий баланс: " + Balance);
                labelHeadLevel.setText("Уровень штаба " + headLevel);
            }
        }
    }


    public MainWindow(){
        super("Эмулятор шахт");
        this.setBounds(100, 100, 300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 10, 5, 5));

        container.add(labelInfo);
        container.add(labelHeadLevel);
        buttonUpgradeHead.addActionListener(new buttonUpgradeHeadListener());
        container.add(buttonUpgradeHead);



        container.add(labelBalance);
        container.add(labelMineCount);




        container.add(labelMineInfo);

        buttonAddMine.addActionListener(new buttonAddMineListener());
        container.add(buttonAddMine);


        container.add(labelDayIncome);

        container.add(labelDayCount);
        buttonNextDay.addActionListener(new buttonNextDayActionListener());
        container.add(buttonNextDay);
    }
}
