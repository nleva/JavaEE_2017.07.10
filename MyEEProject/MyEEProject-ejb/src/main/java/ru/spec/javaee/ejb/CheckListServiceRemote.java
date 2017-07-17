package ru.spec.javaee.ejb;

import java.util.List;

import javax.ejb.Remote;

import ru.spec.javaee.entity.CheckList;

@Remote
public interface CheckListServiceRemote {

	List<CheckList> getCheckLists();

	CheckList createCheckList(String name);

}
