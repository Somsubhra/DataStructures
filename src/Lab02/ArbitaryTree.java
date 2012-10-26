/**
 * 
 * @author Somsubhra(201101056)
 */

public class ArbitaryTree{
	ArbitaryNode root;
	ArbitaryNode a = new ArbitaryNode();
	ArbitaryNode b = new ArbitaryNode();
	ArbitaryNode c = new ArbitaryNode();
	ArbitaryNode d = new ArbitaryNode();
        ArbitaryNode e = new ArbitaryNode();
        ArbitaryNode f = new ArbitaryNode();
 	ArbitaryNode g = new ArbitaryNode();
        ArbitaryNode h = new ArbitaryNode();
        ArbitaryNode i = new ArbitaryNode();	
	
	public ArbitaryTree(){
			a.data = 10;
			b.data = 11;
			c.data = 12;
			d.data = 13;
			e.data = 14;
			f.data = 15;
			g.data = 16;
			h.data = 17;
			i.data = 18;

			root = a;
			root.c1 = b;
			root.c2 = c;
			root.c3 = d;
			b.c1 = e;
			b.c2 = f;
			b.c3 = null;
			c.c1 = g;
			c.c2 = h;
			c.c3 = i;
			d.c1 = null;
			d.c2 = null;
			d.c3 = null;

	}
}
