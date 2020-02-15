package game.Game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import game.Main;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private JFrame frame;
	
	private boolean running = false;
	private Thread thread;
		
	private BufferedImage background;
	
	public Game() {

		//DIMENÇÃO DO ECRÃ
		Dimension d = new Dimension(Main.WIDTH * Main.SCALE, Main.HEIGHT * Main.SCALE);
		setPreferredSize(d);
		setMaximumSize(d);
		setMinimumSize(d);
		
		//JANELA RESPONSAL POR MOSTRAR O JOGO
		frame = new JFrame(Main.TITLE);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//OUTROS
		background = new BufferedImage(Main.WIDTH, Main.HEIGHT,BufferedImage.TYPE_INT_RGB);
	}
	
	//CICLO DO JOGO "CEREBRO"
	public void run() {
		
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >=1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			//MOSTRA OS TICKS E FPS NO TITULO A CADA 1 SEGUNDO
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(Main.TITLE + " TICKS: "+updates + " FPS: "+frames);
				updates = 0;
				frames = 0;
			}
			
		}
		stop();
	}
		
	//FUNCAO PARA INICIAR O CICLO
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//FUNCAO PARA PARAR O CICLO
	public synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.exit(1);
	}

	//FUNCAO RESPONSÁVEL POR ATUALIZAR O JOGO
	private void tick() {
		
	}
	
	//FUNCAO RESPOSÁVEL POR DESENHAR
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//DESENHO
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		
		g.dispose();
		bs.show();
		
	}

}
