package com.smart.coffee.reactive;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        CompositeDisposable disposable = new CompositeDisposable();
        ObservableList<Integer> toDo = new ObservableList<>();
        Disposable disposable1 = toDo.getObservable()
                .doOnSubscribe(d -> System.out.println("doOnSubscribe"))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .subscribe(s -> System.out.println("@ " + s), Throwable::printStackTrace, () -> System.out.println("Complete 1"));
        Disposable disposable2 = toDo.getObservable().subscribe(s -> System.out.println("* " + s), Throwable::printStackTrace, () -> System.out.println("Complete 2"));
        Disposable disposable3 = toDo.getObservable().subscribe(s -> System.out.println("# " + s), Throwable::printStackTrace, () -> System.out.println("Complete 3"));

        disposable.addAll(
                //disposable1,
                disposable2,
                disposable3
        );

        toDo.add(1);
        toDo.add(2);
        disposable.dispose();
        //disposable.clear();
        toDo.add(3);
        toDo.add(4);
        toDo.onComplete();
        toDo.add(5);
    }

    public static class ObservableList<T> {

        private final List<T> list;
        private final PublishSubject<T> onAdd;

        public ObservableList() {
            this.list = new ArrayList<T>();
            this.onAdd = PublishSubject.create();
        }

        public void add(T value) {
            list.add(value);
            onAdd.onNext(value);
        }

        public Observable<T> getObservable() {
            return onAdd;
        }

        public void onComplete() {
            onAdd.onComplete();
        }

        ;
    }
}