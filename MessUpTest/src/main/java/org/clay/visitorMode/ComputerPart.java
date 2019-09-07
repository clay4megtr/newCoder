package org.clay.visitorMode;

/**
 * 接受操作的接口
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
