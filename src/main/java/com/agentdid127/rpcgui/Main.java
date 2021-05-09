package com.agentdid127.rpcgui;

import com.agentdid127.resourcepack.Options;
import com.agentdid127.resourcepack.PackConverter;
import joptsimple.OptionSet;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    private JPanel RPC;
    private JComboBox comboBox1;
    private JTextPane initalVersionTextPane;
    private JComboBox comboBox2;
    private JTextPane finalVersionTextPane;
    private JCheckBox minifyCheckBox;
    private JButton convertResourcePackButton;
    private JTextArea consoleOutputTextArea;


    String from = "1.8";
    String to = "1.8";
    boolean minify = false;
    public Main() {
        convertResourcePackButton.addActionListener(e -> {

            redirectSystemStreams();

            ArrayList<String> argSetup = new ArrayList<>();

            argSetup.add("--from");
            argSetup.add(comboBox1.getSelectedItem().toString());
            argSetup.add("--to");
            argSetup.add(comboBox2.getSelectedItem().toString());

            minify = minifyCheckBox.isSelected();
            if (minify) argSetup.add("--minify");


            String[] args = new String[argSetup.size()];

            for (int i = 0; i < argSetup.size(); i++) {
                args[i] = argSetup.get(i);
                System.out.println(args[i]);
            }


            try {
                OptionSet optionSet = Options.PARSER.parse(args);
                if (optionSet.has(Options.HELP)) {
                    Options.PARSER.printHelpOn(System.out);
                    return;
                }

                new PackConverter(optionSet).run();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Resource Pack Converter");
        frame.setContentPane(new Main().RPC);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    //The following codes set where the text get redirected. In this case, jTextArea1
    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                consoleOutputTextArea.append(text);
            }
        });
    }

    //Followings are The Methods that do the Redirect, you can simply Ignore them.
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateTextArea(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextArea(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        RPC = new JPanel();
        RPC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("1.8");
        defaultComboBoxModel1.addElement("1.9");
        defaultComboBoxModel1.addElement("1.10");
        defaultComboBoxModel1.addElement("1.11");
        defaultComboBoxModel1.addElement("1.11.1");
        defaultComboBoxModel1.addElement("1.11.2");
        defaultComboBoxModel1.addElement("1.12.2");
        defaultComboBoxModel1.addElement("1.13");
        defaultComboBoxModel1.addElement("1.13.1");
        defaultComboBoxModel1.addElement("1.13.2");
        defaultComboBoxModel1.addElement("1.14");
        defaultComboBoxModel1.addElement("1.14.1");
        defaultComboBoxModel1.addElement("1.14.2");
        defaultComboBoxModel1.addElement("1.14.3");
        defaultComboBoxModel1.addElement("1.14.4");
        defaultComboBoxModel1.addElement("1.15");
        defaultComboBoxModel1.addElement("1.15.1");
        defaultComboBoxModel1.addElement("1.15.2");
        defaultComboBoxModel1.addElement("1.16");
        defaultComboBoxModel1.addElement("1.16.1");
        defaultComboBoxModel1.addElement("1.16.2");
        defaultComboBoxModel1.addElement("1.16.3");
        defaultComboBoxModel1.addElement("1.16.4");
        defaultComboBoxModel1.addElement("1.16.5");
        comboBox1.setModel(defaultComboBoxModel1);
        RPC.add(comboBox1);
        initalVersionTextPane = new JTextPane();
        initalVersionTextPane.setText("Inital Version");
        RPC.add(initalVersionTextPane);
        comboBox2 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("1.8");
        defaultComboBoxModel2.addElement("1.9");
        defaultComboBoxModel2.addElement("1.10");
        defaultComboBoxModel2.addElement("1.11");
        defaultComboBoxModel2.addElement("1.11.1");
        defaultComboBoxModel2.addElement("1.11.2");
        defaultComboBoxModel2.addElement("1.12.2");
        defaultComboBoxModel2.addElement("1.13");
        defaultComboBoxModel2.addElement("1.13.1");
        defaultComboBoxModel2.addElement("1.13.2");
        defaultComboBoxModel2.addElement("1.14");
        defaultComboBoxModel2.addElement("1.14.1");
        defaultComboBoxModel2.addElement("1.14.2");
        defaultComboBoxModel2.addElement("1.14.3");
        defaultComboBoxModel2.addElement("1.14.4");
        defaultComboBoxModel2.addElement("1.15");
        defaultComboBoxModel2.addElement("1.15.1");
        defaultComboBoxModel2.addElement("1.15.2");
        defaultComboBoxModel2.addElement("1.16");
        defaultComboBoxModel2.addElement("1.16.1");
        defaultComboBoxModel2.addElement("1.16.2");
        defaultComboBoxModel2.addElement("1.16.3");
        defaultComboBoxModel2.addElement("1.16.4");
        defaultComboBoxModel2.addElement("1.16.5");
        comboBox2.setModel(defaultComboBoxModel2);
        RPC.add(comboBox2);
        finalVersionTextPane = new JTextPane();
        finalVersionTextPane.setText("Final Version");
        RPC.add(finalVersionTextPane);
        minifyCheckBox = new JCheckBox();
        minifyCheckBox.setText("Minify");
        RPC.add(minifyCheckBox);
        convertResourcePackButton = new JButton();
        convertResourcePackButton.setText("Convert Resource Pack");
        RPC.add(convertResourcePackButton);
        consoleOutputTextArea = new JTextArea(20, 40);
        consoleOutputTextArea.setText("Console Output:");
        consoleOutputTextArea.setWrapStyleWord(true);
        consoleOutputTextArea.setLineWrap(true);
        RPC.add(new JScrollPane(consoleOutputTextArea));

        //RPC.add(consoleOutputTextArea);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return RPC;
    }
}
