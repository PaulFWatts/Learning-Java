/**
 * Actor DataType (6.1PP Objects as records)
 *
 * This DataType enables the creation of relevant details for Actors being
 * considered for casting.
 * 
 * @author Paul Watts
 * @version 1.0 (August 2020)
 *
 */

public class Actor {
  private String name; // First and last name of the Actor
  private int membershipId; // Screen Actors Guild membership number
  private int revenue; // Expected revenue film contribution in AUD$M

  public Actor(String name, int membershipId, int revenue) {
    this.name = name;
    this.membershipId = membershipId;
    this.revenue = revenue;
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

  // ** toString method to return a nicely formated representation of Actor
  public String toString() {
    String output = name + " [#" + membershipId + "] " + "$" + revenue + "M expected ";
    if (revenue < 5) {
      output = output + "(Sharknado only)";
    } else if (revenue > 50) {
      output = output + "(A-lister)";
    }
    return output;
  }
}
