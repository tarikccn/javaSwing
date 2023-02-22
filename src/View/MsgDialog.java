/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import View.ViewDesign.*;
import com.mysql.cj.protocol.Warning;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Bhop
 */
public class MsgDialog extends JDialog {

    public enum SelectedIcon {
        WARNING_ICON,
        SUCCESS_ICON
    }
    public JFrame frame;
    public CustomButton okButton;
    public CustomButton yesButton;
    public CustomButton noButton;
    private JLabel titleLabel;
    private JLabel explanationLabel;
    private JLabel iconLabel;

    public MsgDialog(JFrame frame, String title, String explanation, int state, SelectedIcon iconState) {
        super(frame, true);
        this.frame = frame;
        this.setUndecorated(true);
        showMsg();
        CustomPanel panel = new CustomPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        panel.setRoundBottomLeft(50);
        panel.setRoundBottomRight(50);
        panel.setRoundTopLeft(50);
        panel.setRoundTopRight(50);
        iconLabel = new JLabel();
        if (iconState == SelectedIcon.WARNING_ICON) {
            iconLabel.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_error_32.png")));
        }
        if (iconState == SelectedIcon.SUCCESS_ICON) {
            iconLabel.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_vote_32.png")));
        }

        int width = getWidth();
        int height = getHeight();
        add(panel);
        iconLabel.setBounds(0, 20, width, 30);
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        okButton = new CustomButton();
        yesButton = new CustomButton();
        noButton = new CustomButton();
        titleLabel = new JLabel();
        explanationLabel = new JLabel();
        titleLabel.setBounds(0, 60, width, 25);
        titleLabel.setText(title);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        explanationLabel.setBounds(0, 80, width, 50);
        explanationLabel.setText(explanation);
        explanationLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel);
        panel.add(explanationLabel);
        panel.add(iconLabel);
        okButton.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_thumbs_up_16.png")));
        yesButton.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_ok_16.png")));
        noButton.setIcon(new ImageIcon(getClass().getResource("/ProjectIcon/icons8_cancel_16.png")));
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        if (state == 0) {

            okButton.setText("Tamam");
            okButton.setColorActive(Color.black);
            okButton.setColorDisable(Color.white);
            okButton.setColor(Color.gray);
            okButton.setColorOver(Color.white);
            okButton.setBorderColor(Color.white);
            okButton.setColorClick(Color.gray);
            okButton.setBounds(width / 2 - 50, 130, 100, 50);
            okButton.setRadius(20);

            panel.add(okButton);
        } else if (state == 1) {
            yesButton.setText("Evet");
            yesButton.setColorActive(Color.black);
            yesButton.setColorDisable(Color.white);
            yesButton.setColor(Color.gray);
            yesButton.setColorOver(Color.white);
            yesButton.setBorderColor(Color.white);
            yesButton.setColorClick(Color.gray);
            yesButton.setBounds(width / 2 + 10, 130, 100, 50);
            yesButton.setRadius(20);
            panel.add(yesButton);

            noButton.setText("Hayır");
            noButton.setColorActive(Color.black);
            noButton.setColorDisable(Color.white);
            noButton.setColor(Color.gray);
            noButton.setColorOver(Color.white);
            noButton.setBorderColor(Color.white);
            noButton.setColorClick(Color.gray);
            noButton.setBounds(width / 2 - 110, 130, 100, 50);
            noButton.setRadius(20);
            panel.add(noButton);
        } else if (state == 2) {
            okButton.setText("Tamam");
            okButton.setColorActive(Color.black);
            okButton.setColorDisable(Color.white);
            okButton.setColor(Color.gray);
            okButton.setColorOver(Color.white);
            okButton.setBorderColor(Color.white);
            okButton.setColorClick(Color.gray);
            okButton.setBounds(width / 2 + 60, 130, 100, 50);
            okButton.setRadius(20);
            panel.add(okButton);

            yesButton.setText("Evet");
            yesButton.setColorActive(Color.black);
            yesButton.setColorDisable(Color.white);
            yesButton.setColor(Color.gray);
            yesButton.setColorOver(Color.white);
            yesButton.setBorderColor(Color.white);
            yesButton.setColorClick(Color.gray);
            yesButton.setBounds(width / 2 - 50, 130, 100, 50);
            yesButton.setRadius(20);
            panel.add(yesButton);

            noButton.setText("Hayır");
            noButton.setColorActive(Color.black);
            noButton.setColorDisable(Color.white);
            noButton.setColor(Color.gray);
            noButton.setColorOver(Color.white);
            noButton.setBorderColor(Color.white);
            noButton.setColorClick(Color.gray);
            noButton.setBounds(width / 2 - 160, 130, 100, 50);
            noButton.setRadius(20);
            panel.add(noButton);
        }

    }

    public void showMsg() {
        setSize(400, 200);
        setLocationRelativeTo(frame);
        //setContentPane(panel);
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));

    }

}
