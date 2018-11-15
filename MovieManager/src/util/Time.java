package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Time {
	public static void setDT(String dtStyle,JLabel time) {
		final JLabel dt = time;
		Timer timeAction = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				if(dtStyle.equals("yyyy-MM-dd")) {
					SimpleDateFormat df = new SimpleDateFormat(dtStyle);
					dt.setText(df.format(new Date(timemillis)));	
				}else if(dtStyle.equals("HH:mm:ss")) {
					SimpleDateFormat df = new SimpleDateFormat(dtStyle);
					dt.setText(df.format(new Date(timemillis)));	
				}
			}
		});
		timeAction.start();
	}
}
