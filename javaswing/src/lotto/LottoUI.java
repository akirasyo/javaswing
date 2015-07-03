package lotto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Lotto lotto;
	JButton btn;
	JPanel panelNorth, panelSouth;
	ImageIcon icon;
	List<JButton> btns;
	public LottoUI() {
		// 필드값 초기화를 생성자에서 하는데
		// 내용이 길어지거나 혹은 별도의 메소드로 초기화 기능을 
		// 처리하고자하면 메소드를 호출하는 문법이 가능하다.
		init();
	}
	private void init() {
		setTitle("로또 추첨기");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		btn = new JButton("로또 번호 추첨");
		// 조립
		btn.addActionListener(this);	// JFrame을 상속받은 객체이므로 가능
		panelNorth.add(btn);
		add(panelNorth, BorderLayout.NORTH);	// 프레임 북쪽에 패널을 붙인다.
		add(panelSouth, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 400, 1200, 300);	// 화면에서 x좌표 300 y좌표 400 가로 1200pixel 세로 300pixel 
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btns.size() == 0) {
			makeBtns();
		}
		lotto.setLotto();
		showLotto();
	}
	private void showLotto() {
		int[] arr = lotto.getLotto();
		for (int i = 0; i < arr.length; i++) {
			btns.get(i).setIcon(getIcon(arr[i]));
		}
	}
	private Icon getIcon(int i) {
		Icon icon = null;
		String imgPath = "src/images/" + Integer.toString(i)+".gif";
		icon  = new ImageIcon(imgPath);
		return icon;
		// return new ImageIcon(imgPath); 으로 처리하면 더 나은 코딩
	}
	private void makeBtns() {
		JButton temp = null;
		for (int i = 0; i < 6 ; i++) { // 로또이기에 6
			temp = new JButton();
			btns.add(temp);
			panelSouth.add(temp);
		}
	}
}
