package br.com.space;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import br.com.space.maquina.StateGame;
import br.com.space.modelo.Fase;
import br.com.space.util.som.Audio;

public class Container extends JFrame {

	private static final long serialVersionUID = 2271094873264268584L;
	private JLabel jLabel;
	private Timer timer;
	private static String PATH_AUDIO = "res\\som\\playgame.wav";

	public Container() throws HeadlessException {

		add(new Fase());
		this.setTitle("Space v 2.0");
		this.setSize(1020, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		jLabel = new JLabel("0");
		jLabel.setFont(new Font(jLabel.getName(), Font.PLAIN, 20));
		this.add(jLabel, BorderLayout.PAGE_END);
		Audio.play(PATH_AUDIO, true, 1f);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (StateGame.isEmJogo()) {
					jLabel.setText("Pontos " + StateGame.obtemPontos());
				}

			}

		};
		this.timer = new Timer(10, actionListener);
		this.timer.start();

//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
//		JMenu fileMenu = new JMenu("Arquivo");
//		JMenu editMenu = new JMenu("Sobre");
//		menuBar.add(fileMenu);
//		menuBar.add(editMenu);
//
//		JMenuItem newAction = new JMenuItem("Novo");
//		JMenuItem exitAction = new JMenuItem("Exit");
//
//		fileMenu.add(newAction);
//
//		fileMenu.addSeparator();
//		fileMenu.add(exitAction);

	}

}
