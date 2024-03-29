package vtrayicon;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TrayClass {

    static TrayIcon trayIcon;
    
    public TrayClass() {
        show();
    }
    
    public static void show() {
        if(!SystemTray.isSupported()) {
            System.exit(0);
        } 
        trayIcon = new TrayIcon(createIcon("/vtrayicon/Icon.png", "Icon"));
        trayIcon.setToolTip("popisek");
        final SystemTray tray = SystemTray.getSystemTray();
        
        final PopupMenu menu = new PopupMenu();
        
        MenuItem about = new MenuItem("About");
        MenuItem exit = new MenuItem("Exit");
        
        menu.add(about);
        menu.addSeparator();
        menu.add(exit);
        
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "nějaký text");
            }
        });
        
         exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        trayIcon.setPopupMenu(menu);
        
        try {
            tray.add(trayIcon);
        } catch (Exception e) {
        }
    }
    
    protected static Image createIcon(String path, String desc) {
        URL imageURL = TrayClass.class.getResource(path);
        return (new ImageIcon(imageURL, desc).getImage());
    }
    
}
