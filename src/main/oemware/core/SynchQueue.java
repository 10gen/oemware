/**
 * (C) Copyright 2007, Deft Labs.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published 
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package oemware.core;

// Java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * The synchronous (blocking) queue. 
 *
 * @author Ryan Nitz
 * @version $Id: SynchQueue.java 95 2008-10-11 16:18:21Z oemware $
 */
public final class SynchQueue {

    private volatile BlockingQueue<Object> mQueue; 

    /**
     * Construct a new queue.
     * @param pFair Set to true fo fair.
     */
    public SynchQueue(final boolean pFair) 
    { mQueue = new SynchronousQueue<Object>(pFair); }

    /**
     * Construct a new queue (default not fair).
     */
    public SynchQueue() { this(false); }
        
    /**
     * Take the object. Blocks if no object.
     * @return The new object.
     * @throws InterruptedException
     */
    public final Object take() throws InterruptedException
    { return mQueue.take(); }

    /**
     * Add an element.
     * @throws InterruptedException
     */
    public final void put(final Object pObj) throws InterruptedException 
    { mQueue.put(pObj); }
        
    /**
     * Stop the queue.
     */
    public final void shutdown() { }
    public final void startup() { }
}
