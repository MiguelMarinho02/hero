import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

class Game {
    Screen screen;
    private int x = 10;
    private int y = 10;
    Game(){
        try{
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp){
            y--;
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            y++;
        }
        if (key.getKeyType() == KeyType.ArrowRight){
            x++;
        }
        if (key.getKeyType() == KeyType.ArrowLeft){
            x--;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            try {
                screen.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(key);
    }
    public void run() throws IOException {
        while(true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if(KeyType.EOF == key.getKeyType()){
                break;
            }
        }
    }

}
