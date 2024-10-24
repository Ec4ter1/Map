package service;

import domain.Prietenie;
import domain.Utilizator;
import domain.validator.ValidationException;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<ID> {

    /**
     *
     * @param u - the entity that has to be added
     * @return true if the entity was added
     *         false otherwise
     * @throws IllegalArgumentException
     *                  if entity is null
     * @throws ValidationException
     *                  if the entity validation did not work.
     */
    boolean addUser(Utilizator u);


    /**
     *
     * @param id - the id of the entity that we have to remove
     * @return the entity that was removed if there was any
     *         null otherwise
     * @throws IllegalArgumentException
     *                  if id is null
     */
    Optional deleteUser(ID id);


    /**
     *
     * @param id1 and
     * @param id2 - the emails of the user we have to create a friendship between
     *
     * @return true if the entity was added
     *         false otherwise
     * @throws IllegalArgumentException
     *                  if any of the emails are null
     * @throws ValidationException
     *                  if the emails are the same (you cannot add yourself as a friend)
     */
    boolean createFriendship(ID id1, ID id2);


    /**
     * The function deletes a friendship between two users
     *  @param id1 and
     *  @param id2 - the emails of the user we have to create a friendship between
     *
     *  @return the friendship if it exists
     *          null otherwise
     *  @throws IllegalArgumentException
     *                if any of the emails are null
     */
    Optional deleteFriendship(ID id1, ID id2);


    Iterable<Utilizator> getAllUsers();


    /**
     * @return an Iterable of all the friendships
     */
    Iterable<Prietenie> getAllFriendships();


    /**
     * Adds predefined users and friendships
     * @param i : int - represents what iteration of predefined values we add to the repos
     */
    void add_Predefined_Values(int i);

    /**
     * @return an int that represents the number of communities
     */
    int numberOfCommunities();


    /**
     * Returns the most sociable community
     * the most sociable community is the community of users with the longest path
     *
     * @return an Iterable of all the most sociable communities users
     */
    Iterable<Iterable<Utilizator>> mostSociableCommunity();


    List<List<Utilizator>> getAllCommunities();


}
