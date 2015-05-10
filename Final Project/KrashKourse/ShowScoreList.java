package KrashKourse;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * 
 * @author Justin
 *
 *
 *	Shows a frame with a textarea with all of the scores from a selected person;
 *
 *	Shows a JoptionPane with all of values in map, sorted
 *	hen a name is selected, another frame pops up with all of the plaers scores that were found
 */

public class ShowScoreList extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HashMap<String, ArrayList<Integer>> masterList;
	private String scoresStr, playerName;

	public ShowScoreList(HashMap<String, ArrayList<Integer>> playerList) {
		masterList = playerList;

		// Shows a JOptionPane with all keys from Map
		Object keys[] = masterList.keySet().toArray();
		Arrays.sort(keys);

		playerName = (String)JOptionPane.showInputDialog(
				new JFrame(),
				"Whose scores do you wish to see?",
				"Player Select", JOptionPane.PLAIN_MESSAGE,
				null, keys, null);

		if(playerName != null && playerName.length() != 0)
		{
			//Open a list of all of the values stored in that particular player
			//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			//setLocationRelativeTo(null);
			setResizable(false);
			pack();
			validate();
			setSize(350, 250);
			setLayout(null);

			JPanel bck = new JPanel();
			bck.setBackground(Color.DARK_GRAY);
			bck.setBounds(0, 0, getWidth(), getHeight() - 20);
			bck.setLayout(null);
			add(bck);

			//Get scores
			getScores();

			//Text View
			JTextArea text = new JTextArea();
			text.setBounds(5, 5, bck.getWidth() - 10, bck.getHeight() - 80);
			text.setBackground(Color.WHITE);
			text.setText(scoresStr);
			text.setEditable(false);
			text.setAlignmentX(CENTER_ALIGNMENT);
			text.setWrapStyleWord(true);
			text.setLineWrap(true);

			JScrollPane scroll = new JScrollPane (text, 
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			bck.add(scroll);
			scroll.setBounds(text.getBounds());
			scroll.setWheelScrollingEnabled(true);
			scroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			text.setCaretPosition(0);

			///Close Btn
			JButton close = new JButton("Close Scores");
			close.setBounds(bck.getWidth() / 2 - 150, text.getY() + text.getHeight() + 15, 300, 50);
			close.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			bck.add(close);
			repaint();

			setVisible(true);

			setLocationRelativeTo(null);
		}
	}

	public void getScores()
	{
		DecimalFormat df = new DecimalFormat("###,###,##0");
		ArrayList<Integer> tempList = masterList.get(playerName);
		Collections.sort(tempList);
		Collections.reverse(tempList);
		scoresStr = playerName +":\n";

		for(Integer a : tempList)
		{
			if(a != null)
			{
				scoresStr += "\n\t" + df.format(a);
			}
		}
		scoresStr+= "\n";
	}

	public HashMap<String, ArrayList<Integer>> getMasterList() {
		return masterList;
	}

}
