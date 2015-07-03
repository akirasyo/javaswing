package swing;
//스윙은 객체지향 언어의 대표적 예제
//그래서 커리큘럼에 배치됨
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	public MyFrame() {
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 우측상단의 창 닫기 버튼
		setTitle("스윙 예제");
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// 툴킷의 객체를 생성
		Dimension dim = toolkit.getScreenSize();	// 스윙 객체가 보여지는 위치 선정
		//패널 생성
		JPanel panel = new JPanel();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();
		//패널 색상 변경
		panel.setBackground(Color.GREEN);
		panelA.setBackground(Color.BLUE);
		panelB.setBackground(Color.CYAN);
		//레이블 객체 생성
		JLabel label = new JLabel("MVC 모델의 역할 분담");
		panelA.add(label);
		//버튼 객체 생성
		JButton button1 = new JButton("Model : 자바");
		JButton button2 = new JButton("View : JSP");
		JButton button3 = new JButton("Controller : 서블릿");
		JButton button4 = new JButton("(+)Database : 오라클");
		//패널에 버튼을 추가
		panelB.add(button1);		panelB.add(button2);		panelB.add(button3);		panelB.add(button4);
		//패널에 패널A와 패널B를 설치
		panel.add(panelA);		panel.add(panelB);
		//프래임에 패널을 설치
		add(panel);
		setLocation(dim.width/2, dim.height/2);	// 화면 중앙근처에 위치 시킴
		setVisible(true);
	}
}