package com.mindtree.kalingalibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingalibrary.entity.Library;
@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	Optional<Library> findByLibraryName(String libraryName);

}
