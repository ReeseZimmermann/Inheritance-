
class RangeList extends IntegerList{
	
	public RangeList() 
	{
		super();
	}
	public RangeList(int lowerBound, int upperBound) {
		super();
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
		}
		for(int i = lowerBound; i<= upperBound; i++) {
			super.insert(i, 1);;
		}
	}
	
    public void add(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        }
        if (isEmpty()) {
            for (int i = lowerBound; i <= upperBound; i++) {
                insert(size, i);
            }
        } else {
            int startIdx = indexOf(lowerBound);
            int endIdx = indexOf(upperBound);

            if (startIdx == -1 && endIdx == -1) {
                super.insert(lowerBound, upperBound);
            } else {
                int newLowerBound = (startIdx == -1) ? lowerBound : get(startIdx);
                int newUpperBound = (endIdx == -1) ? upperBound : get(endIdx);

                if (startIdx != -1) {
                    removeRange(startIdx, endIdx);
                }

                if (endIdx != -1) {
                    removeRange(startIdx, endIdx);
                }

                super.insert(newLowerBound, newUpperBound);
            }
        }
    }

    
    public void remove(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("The upper bound must be greater than or equal to the lower bound.");
        }
        if (isEmpty()) {
            throw new UnsupportedOperationException("Cannot remove range from an empty list.");
        }

        int startIdx = indexOf(lowerBound);
        int endIdx = indexOf(upperBound);

        if (startIdx == -1 || endIdx == -1) {
            throw new IllegalArgumentException("Lower and/or upper bounds are out of the current list range.");
        }

        if (startIdx != 0 && endIdx != size() - 1) {
            throw new IllegalArgumentException("Cannot remove non-terminal ranges.");
        }
        super.remove(lowerBound);
    }

    private boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException("Insertion is not supported for RangeList.");
    }

    @Override
    public void add(int integer) {
        throw new UnsupportedOperationException("Single integer addition is not supported for RangeList.");
    }

    private void removeRange(int startIdx, int endIdx) {
        for (int i = endIdx; i >= startIdx; i--) {
            super.remove(i);
        }
    }
}