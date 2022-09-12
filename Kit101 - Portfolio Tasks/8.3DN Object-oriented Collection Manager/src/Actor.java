/**
 * Actor DataType (6.2CR Objects with more abilities)
 *
 * This DataType enables the creation of relevant details for Actors being
 * considered for casting. 2020-08-21 Added the enum Skill with relevant values
 * and modified toString accordingly 2020-08-21 Added method to calculate
 * Agent's commission and added this to the DataType
 *
 * @author Paul Watts
 * @version 1.1 (August 2020)
 *
 */

public class Actor {
    public enum Skill {
        WOODEN, HAM, OSCAR_WORTHY
    };

    private Skill skill; // Skill level of the actor
    private String name; // First and last name of the Actor
    private int membershipId; // Screen Actors Guild membership number
    private int revenue; // Expected revenue film contribution in AUD$M
    private double commission; // The commission paid to an agent in AUD$

    public Actor(String name, int membershipId, int revenue, Skill skill, double commission) {
        this.name = name;
        this.membershipId = membershipId;
        this.revenue = revenue;
        this.skill = skill;
        this.commission = commission;
    }

    // ** Returns the Actor name */
    public String getName() {
        return name;
    }

    // ** Sets the Actor name */
    public void setName(String actorName) {
        name = actorName;
    }

    // ** Returns the Actor Screen Actors Guild membership id */
    public int getMembershipId() {
        return membershipId;
    }

    // ** Sets the Actor Screen Actors Guild membership id */
    public void setMembershipId(int actorMembershipId) {
        membershipId = actorMembershipId;
    }

    // ** Returns the Actor revenue */
    public int getRevenue() {
        return revenue;
    }

    // ** Sets the Actor revenue */
    public void setRevenue(int actorRevenue) {
        revenue = actorRevenue;
    }

    // ** Returns the Actor skill */
    public Skill getSkill() {
        return skill;
    }

    // ** Sets the Actor skill */
    public void setSkill(Skill actorSkill) {
        skill = actorSkill;
    }

    // ** Returns Agent's commission paid to the agent based on 1% of revenue
    public double getCommission() {
        commission = revenue * 10000;
        return commission;
    }

    /*
     * Sets the Agent Commission (to allow calculation outside this class in the
     * future) /* If this is required in the future would adjust the getCommission
     * method accordingly /* by checking if a commmision was passed and if not
     * making the 1% a default value (would do this logic /* in the constructor and
     * remove the calculation from the getCommission method
     */

    public void setCommission(double actorCommission) {
        commission = actorCommission;
    }

    // ** toString method to return a nicely formated representation of Actor
    public String toString() {
        String output = skill + " " + name + " [#" + membershipId + "] " + "$" + revenue + "M expected ";
        if (revenue < 5) {
            output = output + "(Sharknado only)";
        } else if (revenue > 50) {
            output = output + "(A-lister)";
        }
        return output;
    }
}
