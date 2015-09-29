package info.abner.factories;

import junit.framework.TestCase;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.io.IOException;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

public class TestFactory extends TestCase {
    public void testScriptEngines(){
        ScriptEngineManager manager = new ScriptEngineManager();
	    List<ScriptEngineFactory> factories = manager.getEngineFactories();
	     
        for (ScriptEngineFactory factory : factories) {
            String language = factory.getLanguageName();
            String version = factory.getLanguageVersion();
            String version2 = factory.getEngineVersion();
            String engine = factory.getEngineName();
            System.out.println("ENGINE: " + engine +  ",LANGUAGE: " + language + ", VERSION: " + version + " " + version2);
        }
    }
    
    public void testFactory() throws IOException, ScriptException, NoSuchMethodException{
        Stopwatch stopwatch = Stopwatch.createStarted();
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        System.out.println("Time of execution in seconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        
        stopwatch = Stopwatch.createStarted();
        engine.eval("var window = {};");
        System.out.println("Time of execution in seconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        
        stopwatch = Stopwatch.createStarted();
        engine.eval(new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/js/vendor/rosie.js"))));
        System.out.println("Time of execution in seconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        
        stopwatch = Stopwatch.createStarted();
        engine.eval(new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/js/vendor/Faker.js"))));
        System.out.println("Time of execution in seconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
        
        stopwatch = Stopwatch.createStarted();
        engine.eval(new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/js/myFactories.js"))));
        System.out.println("Time of execution in seconds:" + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
     	System.out.println("OK");
    }
}
