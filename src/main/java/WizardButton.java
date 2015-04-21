import java.awt.*;
import java.awt.event.KeyEvent;

public class WizardButton {
	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < 20; i++) {
			robot.keyPress(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}
}
