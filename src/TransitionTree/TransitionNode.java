package TransitionTree;
public class TransitionNode{
	public boolean isGuarded;
	public String guard;
	public String effect;
	public String guardBody;
	public String effectBody;
	public StateNode target;
	public String name;
	public TransitionNode(boolean g, String gl, String gb, String el, String eb, StateNode t, String n)
	{
		isGuarded=g;
		guard=gl;
		guardBody=gb;
		effect=el;
		effectBody=eb;
		target=t;
		name=n;
	}
}