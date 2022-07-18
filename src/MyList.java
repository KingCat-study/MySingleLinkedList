public interface MyList<E> {

    /**
     * 리스트에 요소를 추가.
     *
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우
     *          -> 이미 중복되는 요소가 있으면 {@code false} 반환
     *          -> 중복되는 요소가 없을 경우 {@code true} 반환
     */
    boolean add(E value);

    /**
     * 리스트의 특정 위치(index)에 요소를 추가.
     * 특정 위치 이 후의 요소들은 한 칸씩 뒤로 Shift 됩니다.
     *
     * @param index 리스트의 추가될 요소의 특정 위치
     * @param value 리스트에 추가할 요소소     */
    void add(int index, E value);

    /**
     * 리스트의 특정 위치에 있는 요소를 삭제합니다.
     * 
     * @param index 삭제할 요소가 있는 특정 위치
     * @return 삭제된 요소를 반환
     */
    E remove(int index);

    /**
     * 리스트에서 특정 요소와 동일한 요소를 삭제합니다.
     * 동일한 요소가 여러 개일 경우 가장 처음 발견한 요소만 삭제합니다.
     * 
     * @param value 리스트에서 삭제할 특정 요소
     * @return 삭제할 요소가 없거나 삭제에 실패할 경우 {@code false} 반환하고
     *         삭제에 성공할 경우 {@code true} 반환 
     */
    boolean remove(Object value);

    /**
     *리스트의 특정 위치에 있는 요소를 반환.
     *
     * @param index 특정 위치
     * @return 특정 위치에 있는 요소
     */
    E get(int index);

    /**
     * 리스트의 특정 위치에 있는 요소를 새 요소로 대체합니다.
     *
     * @param index 새 요소로 대체 할 기존 요소가 있는 특정 위치
     * @param value 대체될 새 요소
     */
    void set(int index, E value);

    /**
     * 리스트에 특정 요소가 있는지를 판별한다.
     * 
     * @param value 리스트에서 찾을 특정 요소
     * @return 리스트에 특정 요소가 존재 할 경우 {@code true} 반환
     *         리스트에 특정 요소가 존재 하지 않을 경우 {@code false} 반환
     */
    boolean contains(E value);


    /**
     * 리스트에 특정 요소가 몇 번째에 위치해 있는지 판별한다.
     *
     * @param value 위치를 찾을 특정 요소
     * @return 특정 요소가 리스트에서 처음으로 요소와 일치하는 위치를 반환
     *         일치하는 요소가 없을 경우 -1을 반환
     */
    int indexOf(E value);

    /**
     * 리스트에 요소가 몇 개 있는지를 반환.
     *
     * @return 리스트에 있는 요소의 개수 반환
     */
    int size();


    /**
     * 리스트에 요소가 하나도 없이 비어 있는지 여부를 번환
     * 
     * @return 리스트에 요소가 하나도 없으면 {@code true} 반환
     *         리스트에 요소가 하나라도 있으면 {@code false} 반환
     */
    boolean isEmpty();

    /**
     * 리스트에 있는 모든 요소를 제거.
     *
     */
    public void clear();

}
