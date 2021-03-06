package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class loop extends Command {
    node ptr;
    public loop(String o1, node p)
    {
        operStr1 = o1;
        ptr = p;
    }

    @Override
    public void func() {
        Register.set("cx", Register.get("cx") - 1);
        if (Register.get("cx") > 0)
        {
            CmdBuffer p;
            p = label_buf;
            while (p != null)
            {
                if (operStr1.equals(p.label_name))
                {
                    ptr.convert(p.label_site);
                    return;
                }
                p = p.next_label;
            }
        }
        else
        {
            ptr.convert(null);
        }
    }
}
