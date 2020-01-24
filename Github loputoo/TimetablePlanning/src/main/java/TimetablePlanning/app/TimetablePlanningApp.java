package TimetablePlanning.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import TimetablePlanning.Domain.TimetableSolution;

public class TimetablePlanningApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("org.TimetablePlanning", "TimetablePlanning", "1.0.0"));
		SolverFactory<TimetableSolution> solverFactory = SolverFactory.createFromXmlResource("TimetablePlanning/Solver/defenseTimetableSolverConfig.xml");
		Solver<TimetableSolution> solver = solverFactory.buildSolver();
	}

}
