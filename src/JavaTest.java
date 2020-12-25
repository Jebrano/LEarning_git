import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaTest {
    public static void main(String[] args) {
        CheckBox window = new CheckBox();

        window.setSize(200,100);
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
class CheckBox extends JFrame{
    private JTextField textField;
    private JCheckBox boldCheck;
    private JCheckBox italicCheck;


    CheckBox(){
        super("JCHeckBoxFrame");
        setLayout(new FlowLayout());
        textField = new JTextField("Do the nae nae", 30);
        textField.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        add(textField);

        boldCheck = new JCheckBox("Bold");
        italicCheck = new JCheckBox("Italic");
        add(boldCheck); add(italicCheck);
        CHeckBoxHandler handler = new CHeckBoxHandler();
        boldCheck.addItemListener(handler);
        italicCheck.addItemListener(handler);

    }
    private class CHeckBoxHandler implements ItemListener{
        private int valBold = Font.PLAIN;
        private int valItalic = Font.PLAIN;
        public void itemStateChanged(ItemEvent event){
            if(event.getSource() == boldCheck){
                valBold = boldCheck.isSelected()? Font.BOLD : Font.PLAIN;
            }
            if(event.getSource() == italicCheck){
                valItalic = italicCheck.isSelected()? Font.ITALIC: Font.PLAIN;
            }
            textField.setFont(new Font("TimesRoman", valBold + valItalic, 14));
        }
    }
}