/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objectmentor.utilities.args;

import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;
import java.util.*;

/**
 *
 * @author luka
 */
public class StringArrayArgumentMarshaler implements ArgumentMarshaler {

    protected String[] stringArrayValue;

    @Override
    public void set(ListIterator<String> currentArgument) throws ArgsException {
        List<String> parameters = new ArrayList<String>();
        try {
            while (currentArgument.hasNext()) {
                String argString = currentArgument.next();
                if (argString.startsWith("-")) {
                    currentArgument.previous();
                    break;
                }
                parameters.add(argString);
            }
            stringArrayValue = parameters.toArray(new String[parameters.size()]);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String[] getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArrayArgumentMarshaler) {
            return ((StringArrayArgumentMarshaler) am).stringArrayValue;
        } else {
            return new String[]{};
        }
    }
}
