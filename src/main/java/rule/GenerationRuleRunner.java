package rule;

import model.impl.World;

public interface GenerationRuleRunner {
    void run(World world, CellRule cellRuleEngine);
}
