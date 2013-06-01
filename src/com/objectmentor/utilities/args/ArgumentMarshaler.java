/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objectmentor.utilities.args;

import java.util.*;

/**
 *
 * @author luka
 */
public interface ArgumentMarshaler {

    void set(ListIterator<String> currentArgument) throws ArgsException;
}
