package com.smartfox.todobatch.config;

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step step1() {
		return this.stepBuilderFactory.get("step1")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println(">> This is step 1");
						return RepeatStatus.FINISHED;
					}
				}).build();
	}
	
	public Step step2() {
		return this.stepBuilderFactory.get("step2")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println(">> This is step 2");
						return RepeatStatus.FINISHED;
					}
				}).build();
	}
	
	public Step step3() {
		return this.stepBuilderFactory.get("step3")
				.tasklet(new Tasklet() { // Can use a lambda
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println(">> This is step 3");
						return RepeatStatus.FINISHED;
					}
				}).build();
	}
	
	@Bean
	public Job firstJob() {
		return this.jobBuilderFactory.get("stepbystep")
				.start(step1())
				.next(step2())
				.next(step3())
				.build();
	}
	
	//@Bean
	public Job secondJob() {
		return this.jobBuilderFactory.get("chainableoncompletedsteps")
				.start(step1())
				.on("COMPLETED").to(step2())
				.from(step2()).on("COMPLETED").to(step3())
				.from(step3()).end()
				.build();
	}
	
	//@Bean
	public Job failJob() {
		return this.jobBuilderFactory.get("failingjob")
		.start(step1())
		.on("COMPLETED").to(step2())
		.from(step2()).on("COMPLETED").fail().end()
		.build();
	}
	
	//@Bean
	public Job failandrestart() {
		return this.jobBuilderFactory.get("restartjob")
				.start(step1())
				.on("COMPLETED").to(step2())	
				.from(step2()).on("COMPLETED").stopAndRestart(step3())// Can be useful when requiring human intervention - restart at step 3
				.from(step3()).end()
				.build();
	}
	
	
}
