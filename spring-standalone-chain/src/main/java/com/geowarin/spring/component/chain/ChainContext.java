package com.geowarin.spring.component.chain;

public class ChainContext {

	private final boolean compatibleWithFirstElement;
	private final boolean compatibleWithSecondElement;
	
	private boolean handledByFirst;
	private boolean handledBySecond;

	public ChainContext(boolean compatibleWithFirstElement, boolean compatibleWithSecondElement) {
		this.compatibleWithFirstElement = compatibleWithFirstElement;
		this.compatibleWithSecondElement = compatibleWithSecondElement;
	}

	public boolean isCompatibleWithFirstElement() {
		return compatibleWithFirstElement;
	}

	public boolean isCompatibleWithSecondElement() {
		return compatibleWithSecondElement;
	}

	public boolean isHandledByFirst() {
		return handledByFirst;
	}

	public void setHandledByFirst(boolean handledByFirst) {
		this.handledByFirst = handledByFirst;
	}

	public boolean isHandledBySecond() {
		return handledBySecond;
	}

	public void setHandledBySecond(boolean handledBySecond) {
		this.handledBySecond = handledBySecond;
	}
}
