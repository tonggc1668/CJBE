package org.apache.bcel.verifier.structurals;

/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache BCEL" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache BCEL", nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */


/**
 * This class represents a JVM execution frame; that means,
 * a local variable array and an operand stack.
 *
 * @author <A HREF="http://www.inf.fu-berlin.de/~ehaase"/>Enver Haase</A>
 * @version $Id: Frame.java,v 1.2 2006/09/04 15:43:18 andos Exp $
 */

public class Frame {

    /**
     * For instance initialization methods, it is important to remember
     * which instance it is that is not initialized yet. It will be
     * initialized invoking another constructor later.
     * NULL means the instance already *is* initialized.
     */
    protected static UninitializedObjectType _this;

    /**
     *
     */
    private LocalVariables locals;

    /**
     *
     */
    private OperandStack stack;

    /**
     *
     */
    public Frame(int maxLocals, int maxStack) {
        locals = new LocalVariables(maxLocals);
        stack = new OperandStack(maxStack);
    }

    /**
     *
     */
    public Frame(LocalVariables locals, OperandStack stack) {
        this.locals = locals;
        this.stack = stack;
    }

    /**
     *
     */
    protected Object clone() {
        Frame f = new Frame(locals.getClone(), stack.getClone());
        return f;
    }

    /**
     *
     */
    public Frame getClone() {
        return (Frame) clone();
    }

    /**
     *
     */
    public LocalVariables getLocals() {
        return locals;
    }

    /**
     *
     */
    public OperandStack getStack() {
        return stack;
    }

    /**
     *
     */
    public boolean equals(Object o) {
        if (!(o instanceof Frame)) return false; // implies "null" is non-equal.
        Frame f = (Frame) o;
        return this.stack.equals(f.stack) && this.locals.equals(f.locals);
    }

    /**
     * Returns a String representation of the Frame instance.
     */
    public String toString() {
        String s = "Local Variables:\n";
        s += locals;
        s += "OperandStack:\n";
        s += stack;
        return s;
    }
}
