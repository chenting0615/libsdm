/** ------------------------------------------------------------------------- *
 * libpomdp
 * ========
 * File: BeliefState.java
 * Description: interface to implement different representations
 *              of a belief state
 *              properties are to be filled by extending classes
 * Copyright (c) 2008, 2009, 2010 Diego Maniloff 
 * Copyright (c) 2010 Mauricio Araya
 --------------------------------------------------------------------------- */

package libsdm.pomdp;

import java.util.Random;

import libsdm.common.SparseVector;

public interface BeliefState {

	
    /**
     * Get belief state point as a real vector.
     * 
     * @return belief-point
     */
    public SparseVector getPoint();

    /**
     * Get the reachability probability. Pr(o|b,a).
     * 
     * @return the reachability probability.
     */
    public double getPoba();

    /**
     * Set the reachability probability. Pr(o|b,a).
     * 
     * @param poba
     *            the reachability probability
     */
    public void setPoba(double poba);

    // TODO: It is not better to have here the reference of the alpha vector
    // rather
    // than the index??

    /**
     * Get index of the alpha vector that supports this point.
     * 
     * @return the index of the alpha vector that supports this point
     */
   // public int getAlpha();

    /**
     * Set index of the alpha vector that supports this point.
     * 
     * @param planid
     *            the index of the alpha vector that supports this point
     */
   // public void setAlpha(int planid);

    // / returns the entropy of the belief in nats
    public double getEntropy(double e);

    /**
     * Compare with other belief-state.
     * 
     * @param bel
     *            a belief-state.
     * @return true if equals, false else
     */
   // public boolean compare(BeliefState bel);

    /**
     * Create a proper copy of the belief-state.
     * 
     * @return a belief-state copy
     */
    public BeliefState copy();

	public int sample();

	public int sample(Random gen);

	//public double prob(int s);

	//public BeliefState getRange(int ini, int range);

	public void initChildMap(int actions, int observations);

	public ChildMap getChildMap();

	public Double naiveHash();

	public int[] getMask();

	public double prob(int index);

	public double minratio(BeliefState bp);

	public int getCorner();

	
}
