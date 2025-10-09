package Generice;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.security.PublicKey;

class MultipleBoundParam extends Number implements Printable {
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    class Boxx<T extends Number & Printable>
    {

    }

    public class Test {
        public static void main(String[] args)
        {
//            MultipleBoundParam m = new MultipleBoundParam(12);
//            Boxx<MultipleBoundParam> b= new Boxx<MultipleBoundParam>();
        }
    }
}

