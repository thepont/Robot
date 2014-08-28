/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot.interpreter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
import static org.junit.Assert.*;
import org.junit.Test;
import robot.Direction;
import robot.Location;
import robot.Robot;

/**
 *
 * @author Paul Esson
 */
public class IntepreterTest {

    public IntepreterTest() {
    }

    @Test
    public void testExampleOne() {
        Robot r = Robot.getInstance();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String input = "PLACE 0,0,NORTH\n"
                + "MOVE\n"
                + "REPORT";
        String expectedOutput = "0,1,NORTH\n";
        InputStream context = new ByteArrayInputStream(input.getBytes());
        Interpreter instance = new Interpreter();
        instance.interpret(context);
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testExampleTwo() {
        Robot r = Robot.getInstance();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String input = "PLACE 0,0,NORTH\n"
                + "LEFT\n"
                + "REPORT";
        String expectedOutput = "0,0,WEST\n";
        InputStream context = new ByteArrayInputStream(input.getBytes());
        Interpreter instance = new Interpreter();
        instance.interpret(context);
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testExampleThree() {
        Robot r = Robot.getInstance();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String input = "PLACE 1,2,EAST\n"
                + "MOVE\n"
                + "MOVE\n"
                + "LEFT\n"
                + "MOVE\n"
                + "REPORT";
        String expectedOutput = "3,3,NORTH\n";
        InputStream context = new ByteArrayInputStream(input.getBytes());
        Interpreter instance = new Interpreter();
        instance.interpret(context);
        assertEquals(expectedOutput, out.toString());
    }

    /**
     * Test of interpret method, of class Interpreter.
     */
    @Test
    public void testInterpret() {
        Location expLoc = new Location(1, 1, Direction.WEST);
        String commands = "PLACE 1,1,NORTH\n\rLEFT";
        InputStream context = new ByteArrayInputStream(commands.getBytes());
        Interpreter instance = new Interpreter();
        instance.interpret(context);
        Location finalLocation = robot.Robot.getInstance().getCurrentLocation();

        assertEquals(expLoc, finalLocation);
    }

    @Test
    public void testInterpretPlaceLocation() {
        try {
            String context = "3,2,NORTH";
            Interpreter instance = new Interpreter();
            StringTokenizer st = new StringTokenizer(context, ",");
            Location expLoc = new Location(3, 2, Direction.NORTH);
            Location result = instance.interpretPlaceLocation(st);
            assertEquals(expLoc, result);
        } catch (CommandFormatException e) {
            fail("Format Exception on valid input");
        }
    }

    @Test
    public void testInterpretInvalidPlaceLocation() {
        String context = "3,2-NORTH";
        Interpreter instance = new Interpreter();
        StringTokenizer st = new StringTokenizer(context, ",");
        try {
            instance.interpretPlaceLocation(st);
            fail("interpretPlaceLocation should have thrown CommandFormatException");
        } catch (CommandFormatException e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testInterpretCommandPlace() {
        String context = "PLACE 0,1,NORTH";
        StringTokenizer st = new StringTokenizer(context, Interpreter.TOKENS);
        Interpreter instance = new Interpreter();
        try {
            Interpreter.CommandExpression result = instance.interpretCommand(st);
            Interpreter.CommandExpression expected = Interpreter.CommandExpression.PLACE;
            assertEquals(expected, result);
        } catch (CommandFormatException e) {
            fail("Format Exception on valid input");
        }
    }

    @Test
    public void testInterpretCommandMove() {
        String context = "MOVE";
        StringTokenizer st = new StringTokenizer(context, Interpreter.TOKENS);
        Interpreter instance = new Interpreter();
        try {
            Interpreter.CommandExpression result = instance.interpretCommand(st);
            Interpreter.CommandExpression expected = Interpreter.CommandExpression.MOVE;
            assertEquals(expected, result);
        } catch (CommandFormatException e) {
            fail("Format Exception on valid input");
        }
    }

    @Test
    public void testInterpretCommandLeft() {
        String context = "LEFT";
        StringTokenizer st = new StringTokenizer(context, Interpreter.TOKENS);
        Interpreter instance = new Interpreter();
        try {
            Interpreter.CommandExpression result = instance.interpretCommand(st);
            Interpreter.CommandExpression expected = Interpreter.CommandExpression.LEFT;
            assertEquals(expected, result);
        } catch (CommandFormatException e) {
            fail("Format Exception on valid input");
        }
    }

    @Test
    public void testInterpretCommandRight() {
        String context = "RIGHT";
        StringTokenizer st = new StringTokenizer(context, Interpreter.TOKENS);
        Interpreter instance = new Interpreter();
        try {
            Interpreter.CommandExpression result = instance.interpretCommand(st);
            Interpreter.CommandExpression expected = Interpreter.CommandExpression.RIGHT;
            assertEquals(expected, result);
        } catch (CommandFormatException e) {
            fail("Format Exception on valid input");
        }
    }

    @Test
    public void testInterpretCommandReport() {
        String context = "REPORT";
        StringTokenizer st = new StringTokenizer(context, Interpreter.TOKENS);
        Interpreter instance = new Interpreter();
        try {
            Interpreter.CommandExpression result = instance.interpretCommand(st);
            Interpreter.CommandExpression expected = Interpreter.CommandExpression.REPORT;
            assertEquals(expected, result);
        } catch (CommandFormatException e) {
            fail("Format Exception on valid input");
        }
    }

    @Test
    public void testInterpretCommandInvalid() {
        String context = "NOTVALID";
        StringTokenizer st = new StringTokenizer(context, Interpreter.TOKENS);
        Interpreter instance = new Interpreter();
        try {
            instance.interpretCommand(st);
            fail("Invalid input should have thrown exception");
        } catch (CommandFormatException e) {
            assertNotNull(e.getMessage());
        }
    }

}
