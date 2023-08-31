package rule;

import model.impl.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CellRuleEngine implements CellRule {

    private final List<CellRule> rules;

    public CellRuleEngine(final List<CellRule> rules) {
        this.rules = rules;
    }

    @Override
    public void execute(final Cell cell, final List<Cell> neighborCells) {
        Optional.ofNullable(rules)
                .orElse(new ArrayList<>())
                .forEach(rule -> rule.execute(cell, neighborCells));
    }
}
