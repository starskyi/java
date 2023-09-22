package cn.star.script;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class qqScript {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        robot.delay(2000);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection msg = new StringSelection("hello");
        clip.setContents(msg, null);
        for(int i= 0; i < 100; i++){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

    }
}
