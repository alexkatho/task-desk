package com.example.taskdesk.task.domain;

/**
 * Fachlicher Status einer Task.
 *
 * Warum ein Enum?
 * - verhindert Tippfehler
 * - macht erlaubte Werte explizit
 * - ist deutlich sauberer als String-Literale im Code
 *
 * Für unser schlankes System reichen zunächst drei Zustände.
 */
public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;
    
    public boolean isTodo() {
    	return this == TODO;
    }
    
    public boolean isInProgress() {
    	return this == IN_PROGRESS;
    }
    
    public boolean isDone() {
    	return this == DONE;
    }
}