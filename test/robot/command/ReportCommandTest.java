/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robot.command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.Test;
import robot.Direction;
import robot.Location;


/**
 *
 * @author Paul Esson
 */
public class ReportCommandTest {
    
    public ReportCommandTest() {
    }

    /**
     * Test of execute method, of class ReportCommand.
     */
    @Test
    public void testExecute() {
        
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ReportCommand instance = new ReportCommand();
       
        instance.execute(new Location(0,0,Direction.NORTH));
        assertEquals("0,0,NORTH\n", out.toString());
        try
        {
            out.close();
        }
        catch(IOException e){
            fail("issue closing output stream");
        }
    }
    
}
