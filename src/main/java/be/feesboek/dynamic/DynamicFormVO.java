package be.feesboek.dynamic;

import be.feesboek.dynamic.form.Block;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dimitridw
 */
public class DynamicFormVO {
    
    private String name;
    private List<Block> blocks = new ArrayList<>();

    /**
     * @return the blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * @param blocks the blocks to set
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
