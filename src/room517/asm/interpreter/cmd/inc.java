package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class inc extends Command {
    @Override
    public void func() {
        long tmp = Register.get(operStr1);
        Register.setFlags(tmp, 1, Register.OpeType.add);
        Register.set(operStr1, tmp + 1);
    }

    public inc(String o1)
    {
        operStr1 = o1;
        operStr2 = "";
    }
}
